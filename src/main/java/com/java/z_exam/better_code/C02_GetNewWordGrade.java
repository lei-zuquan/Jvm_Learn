package com.java.z_exam.better_code;

import java.util.HashMap;
import java.util.Random;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-04 9:21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_GetNewWordGrade {
    public static void main(String[] args) {
        /*
            Spark一次加载词库，通过小表join大表，得到（词，等级信息）HashMap，通过Spark广播，每个Executor共享只读，整体理论性能有一定提升
         */
        // news_word        (word, news_word_grade_id)
        // news_word_grade  (id, word_grade_value)

        // 1. 加载两张表到spark中，new_word表,new_word_grade表
        // 2. 两表join，使用小表join大表（news_word_grade表 join news_word表）
        // SELECT news_word.`word`, news_word_grade.`word_grade_value` FROM news_word_grade, news_word WHERE news_word.`news_word_grade_id` = news_word_grade.`id`;
        // SELECT news_word.`word`, news_word_grade.`word_grade_value` FROM news_word_grade INNER JOIN news_word WHERE news_word_grade.`id` = news_word.`news_word_grade_id`;

        // 3.两表Join后得到(word, word_grade_value)信息，将其存入HashMap中
        int wordCnt = 2499;
        // 一次扩容成功，不需反复动态扩容提升效率；
        HashMap<String, Integer> wordHashMap = new HashMap<>(wordCnt);
        // 4.使用spark广播变量将wordHashMap广播出去。因为广播变量是只读的，所以HashMap就不存在多线程并发写问题；
        /**
         Broadcast<HashMap<String, Integer>> wordBroadcast = sc.broadcast(NeedBroadCastWordHashMap);
         groupJavaPairDStream.foreachRDD(new VoidFunction<JavaPairRDD<String, Iterable<String>>>() {
        @Override public void call(JavaPairRDD<String, Iterable<String>> rdd) throws Exception {
        // 通过广播变量在Executor取将广播变量值取出
        HashMap<String, Integer> wordHashMap = wordBroadcast.value();


        }
        }); */

        // 模拟词库
        MockWordGrade(wordHashMap, wordCnt);

        // todo: 以下是模拟文章分词匹配问题
        int newsTimes = 7 * 10000; // 假如有7天有7万多篇文章
        Random r = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < newsTimes; i++) {
            for (int j = 1; j <= 10; j++) { // 假设每篇文章有10个词
                // 如果直接与DB查询匹配（因DB建立了B+树索引），假如每次1ms毫秒，共需要：7*10000 * 10 /1000 = 700秒完成
                // 如果与hashMap匹配
                Integer wordGradeValue = wordHashMap.get(r.nextInt(wordCnt) + "");
                //System.out.println(wordGradeValue);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("spend time:" + (endTime - startTime));

    }

    private static void MockWordGrade(HashMap<String, Integer> wordHashMap, int wordCnt) {
        Random r = new Random();
        for (int i = 0; i < wordCnt; i++) {
            // 随机产生一个数
            wordHashMap.put(r.nextInt(wordCnt) + "", i);
        }
    }
}
