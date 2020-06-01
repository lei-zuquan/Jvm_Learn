DROP DATABASE IF EXISTS `news_word`;
CREATE DATABASE IF NOT EXISTS `news_word` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `news_word`;


-- 创建舆情词典
DROP TABLE IF EXISTS `ciku`;
CREATE TABLE `ciku` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `word` VARCHAR(100) NOT NULL COMMENT '舆情词',
  `word_hash` INT UNSIGNED NOT NULL DEFAULT 0 COMMENT '舆情词对应的hashcode',
  `value_num` INT DEFAULT 0 COMMENT '舆情值',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- 创建触发器。先临时修改一下语句分隔符，这样就可以在触发器定义中使用分号;
DELIMITER //

CREATE TRIGGER ciku_crc_ins BEFORE INSERT ON ciku FOR EACH ROW BEGIN 
SET NEW.word_hash=CRC32(NEW.word);
END;
//

CREATE TRIGGER ciku_crc_upd BEFORE UPDATE ON ciku FOR EACH ROW BEGIN 
SET NEW.word_hash=CRC32(NEW.word);
END;
//

DELIMITER ;

TRUNCATE TABLE ciku;
-- 存储过程，循环插入数据
DROP PROCEDURE IF EXISTS proc_initData;
DELIMITER $$$

CREATE PROCEDURE proc_initData()
BEGIN
DECLARE i INT DEFAULT 0;
SET i=1;
START TRANSACTION;
WHILE i<=10000000 DO
 SET @ci = i;
 INSERT INTO `ciku` (`word`, `value_num`) VALUES (@ci, 100);
SET i=i+1;
END WHILE;
COMMIT;
END $$$

DELIMITER ;
CALL proc_initData();



-- 剩下的工作就是验证一下触发器如何维护哈希索引;


-- explain SELECT id, value_num FROM ciku WHERE word_hash=CRC32('造假') AND word='造假';

EXPLAIN SELECT id, value_num FROM ciku WHERE word_hash=CRC32(1) AND word=1;

CREATE INDEX word_hash_index ON `ciku`(`word_hash`) 

SHOW INDEX FROM `ciku`

EXPLAIN SELECT id, value_num FROM ciku WHERE word_hash=CRC32(1000) AND word=1000;

-- 再次插入相同数据表示hashcode值一致
INSERT INTO `ciku` (`word`, `value_num`) VALUES (1 , 100);
INSERT INTO `ciku` (`word`, `value_num`) VALUES (1 , 100);

-- 查询1
SELECT id, value_num FROM ciku WHERE word_hash=CRC32(10) AND word=10;
SELECT COUNT(*) FROM ciku;


/* 
"1"	"SIMPLE"	"ciku"	\N	"ALL"	\N	\N	\N	\N	"9771027"	"1.00"	"Using where"

"1"	"SIMPLE"	"ciku"	\N	"ref"	"word_hash_index"	"word_hash_index"	"4"	"const"	"1"	"10.00"	"Using where"

显示联结类型，显示查询使用了何种类型，按照从最佳到最坏类型排序
1、system：表中仅有一行（=系统表）这是const联结类型的一个特例。
2、const：表示通过索引一次就找到，const用于比较primary key或者unique索引。因为只匹配一行数据，所以如果将主键置于where列表中，mysql能将该查询转换为一个常量
3、eq_ref:唯一性索引扫描，对于每个索引键，表中只有一条记录与之匹配。常见于唯一索引或者主键扫描
4、ref:非唯一性索引扫描，返回匹配某个单独值的所有行，本质上也是一种索引访问，它返回所有匹配某个单独值的行，可能会找多个符合条件的行，属于查找和扫描的混合体
5、range:只检索给定范围的行，使用一个索引来选择行。key列显示使用了哪个索引，一般就是where语句中出现了between,in等范围的查询。这种范围扫描索引扫描比全表扫描要好，因为它开始于索引的某一个点，而结束另一个点，不用全表扫描
6、index:index 与all区别为index类型只遍历索引树。通常比all快，因为索引文件比数据文件小很多。
7、all：遍历全表以找到匹配的行
注意:一般保证查询至少达到range级别，最好能达到ref。


包含不适合在其他列中显示，但是十分重要的额外信息
1、Using filesort：说明mysql会对数据适用一个外部的索引排序。而不是按照表内的索引顺序进行读取。MySQL中无法利用索引完成排序操作称为“文件排序”
2、Using temporary:使用了临时表保存中间结果，mysql在查询结果排序时使用临时表。常见于排序order by和分组查询group by。
3、Using index:表示相应的select操作用使用覆盖索引，避免访问了表的数据行。如果同时出现using where，表名索引被用来执行索引键值的查找；如果没有同时出现using where，表名索引用来读取数据而非执行查询动作。
4、Using where :表明使用where过滤
5、using join buffer:使用了连接缓存
6、impossible where:where子句的值总是false，不能用来获取任何元组
7、select tables optimized away：在没有group by子句的情况下，基于索引优化Min、max操作或者对于MyISAM存储引擎优化count（*），不必等到执行阶段再进行计算，查询执行计划生成的阶段即完成优化。
8、distinct：优化distinct操作，在找到第一匹配的元组后即停止找同样值的动作。

*/ 


/*

 词库存储选型方案一：B+树（MySQL）
 设计如下：
	1、创建舆情词、舆情词对应的hashCode、舆情词对应的舆情值
	2、对舆情词对应的hashCode建立触发器，当插入数据、更新数据会自动维护其对应的hashCode；
	3、对hashCode建立索引，达到快速检索的效果；即后续外围系统传入舆情词，mysql可快带查询出对应的舆情值；

 测试版本：mysql 5.7.24
 	
 测试如下：
	1、使用存储过程向msyql中添加1000千万条数据；
		a、不对hashCode建立索引，查询单条记录消耗3.262秒；
		b、对hashCode建立索引，查询单条记录消耗0.002秒；性能提升百倍

 总结：
	通过B+树的设计，能达到对舆情词的快速查找；


*/

SELECT VERSION();