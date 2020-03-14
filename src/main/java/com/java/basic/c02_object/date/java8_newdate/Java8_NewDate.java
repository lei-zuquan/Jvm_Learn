package com.java.basic.c02_object.date.java8_newdate;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-11 8:49
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Java8_NewDate {
    public static void main(String[] args) {
        /**
         *  示例 1、在Java 8中获取今天的日期
         *  Java 8 中的 LocalDate 用于表示当天日期。和java.util.Date不同，它只有日期，不包含时间。当你仅需要表示日期时就用这个类。
         *  上面的代码创建了当天的日期，不含时间信息。打印出的日期格式非常友好，不像老的Date类打印出一堆没有格式化的信息。
         */
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);


        /**
         * 示例 2、在Java 8中获取年、月、日信息
         * LocalDate类提供了获取年、月、日的快捷方法，其实例还包含很多其它的日期属性。
         * 通过调用这些方法就可以很方便的得到需要的日期信息，不用像以前一样需要依赖java.util.Calendar类了。
         * 在Java 8 中得到年、月、日信息是这么简单直观，想用就用，没什么需要记的。
         */
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d  Month : %d  day : %d t %n", year, month, day);


        /**
         * 示例 3、在Java 8中处理特定日期
         * 在第一个例子里，我们通过静态工厂方法now()非常容易地创建了当天日期，你还可以调用另一个有用的
         * 工厂方法LocalDate.of()创建任意日期， 该方法需要传入年、月、日做参数，返回对应的LocalDate实例。
         * 这个方法的好处是没再犯老API的设计错误，比如年度起始于1900，月份是从0开始等等。日期所见即所得，
         * 就像下面这个例子表示了1月14日，没有任何隐藏机关。
         */
        LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
        System.out.println("Your Date of birth is : " + dateOfBirth);

        /**
         * 示例 4、在Java 8中判断两个日期是否相等
         * 现 实生活中有一类时间处理就是判断两个日期是否相等。你常常会检查今天是不是个特殊的日子，
         * 比如生日、纪念日或非交易日。这时就需要把指定的日期与某个特定 日期做比较，例如判断这一天
         * 是否是假期。下面这个例子会帮助你用Java 8的方式去解决，你肯定已经想到了，LocalDate重载了equal方法，请看下面的例子：
         * 这个例子中我们比较的两个日期相同。注意，如果比较的日期是字符型的，需要先解析成日期对象再作判断。
         */
        LocalDate date1 = LocalDate.of(2020, 03, 11);
        if (date1.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }

        /**
         * 示例 5、在Java 8中检查像生日这种周期性事件
         * Java 中另一个日期时间的处理就是检查类似每月账单、结婚纪念日、EMI日或保险缴费日这些周期性事件。
         * 如果你在电子商务网站工作，那么一定会有一个模块用来在圣诞节、感恩节这种节日时向客户发送问候邮件。
         * Java中如何检查这些节日或其它周期性事件呢？答案就是MonthDay类。这个类组合了月份和日，去掉了年，
         * 这意味着你可以用它判断每年都会发生事件。和这个类相似的还有一个YearMonth类。这些类也都是不可变并
         * 且线程安全的值类型。下面我们通过 MonthDay来检查周期性事件：
         * 只要当天的日期和生日匹配，无论是哪一年都会打印出祝贺信息。你可以把程序整合进系统时钟，看看生日时
         * 是否会受到提醒，或者写一个单元测试来检测代码是否运行正确。
         */
        LocalDate dateOfBirth2 = LocalDate.of(2010, 01, 14);
        MonthDay birthday = MonthDay.of(dateOfBirth2.getMonth(), dateOfBirth2.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);

        if (currentMonthDay.equals(birthday)) {
            System.out.println("Many Many happy returns of the day !!");
        } else {
            System.out.println("Sorry, today is not your birthday");
        }

        /**
         * 示例 6、在Java 8中获取当前时间
         * 与Java 8获取日期的例子很像，获取时间使用的是LocalTime类，一个只有时间没有日期的LocalDate近亲。
         * 可以调用静态工厂方法now()来获取当前时间。默认的格式是hh:mm:ss.nnn。
         * 可以看到当前时间就只包含时间信息，没有日期。
         */
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);

        /**
         * 示例 7、如何在现有的时间上增加小时
         * 通过增加小时、分、秒来计算将来的时间很常见。Java 8除了不变类型和线程安全的好处之外，还提供了更好
         * 的plusHours()方法替换add()，并且是兼容的。注意，这些方法返回一个全新的LocalTime实例，由于其不可变性，返回后一定要用变量赋值。
         */
        LocalTime time7 = LocalTime.now();
        LocalTime newTime = time7.plusHours(2);// adding two hours
        System.out.println("Time after 2 hours : " + newTime);

        /**
         * 示例 8、如何计算一周后的日期
         * 和上个例子计算两小时以后的时间类似，这个例子会计算一周后的日期。LocalDate日期不包含时间信息，
         * 它的plus()方法用来增加天、周、月，ChronoUnit类声明了这些时间单位。由于LocalDate也是不变类型，返回后一定要用变量赋值。
         *
         * 可以看到新日期离当天日期是7天，也就是一周。你可以用同样的方法增加1个月、1年、1小时、1分钟甚至一个世纪，
         * 更多选项可以查看Java 8 API中的ChronoUnit类。
         */
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);

        /**
         * 示例 9、计算一年前或一年后的日期
         * 继续上面的例子，上个例子中我们通过LocalDate的plus()方法增加天数、周数或月数，这个例子我们利用minus()方法计算一年前的日期。
         */
        LocalDate previousYear = today.minus(1, YEARS);
        System.out.println("Date before 1 year : " + previousYear);
        LocalDate nextYear = today.plus(1, YEARS);
        System.out.println("Date after 1 year : " + nextYear);

        /**
         * 示例 10、使用Java 8的Clock时钟类
         * Java 8增加了一个Clock时钟类用于获取当时的时间戳，或当前时区下的日期时间信息。
         * 以前用到System.currentTimeInMillis()和TimeZone.getDefault()的地方都可用Clock替换。
         *
         */
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // Returns time based on system clock zone
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + defaultClock);

        /**
         * 示例 11、如何用Java判断日期是早于还是晚于另一个日期
         * 另一个工作中常见的操作就是如何判断给定的一个日期是大于某天还是小于某天？在Java 8中，
         * LocalDate类有两类方法isBefore()和isAfter()用于比较日期。调用isBefore()方法时，如果给定日期小于当前日期则返回true。
         * 在Java 8中比较日期非常方便，不需要使用额外的Calendar类来做这些基础工作了。
         */
        LocalDate tommorow = LocalDate.of(2014, 1, 15);
        if (tommorow.isAfter(today)) {
            System.out.println("tommorow comes after today");
        }

        LocalDate yesterday = today.minus(1, DAYS);
        if (yesterday.isBefore(today)) System.out.println("Yesterday is day before today");

        /**
         * 示例 12、在Java 8中处理时区
         * Java 8不仅分离了日期和时间，也把时区分离出来了。现在有一系列单独的类如ZoneId来处理特定时区，
         * ZoneDateTime类来表示某时区下的时间。这在Java 8以前都是 GregorianCalendar类来做的。
         * 下面这个例子展示了如何把本时区的时间转换成另一个时区的时间。
         * 和以前使用GMT的方式转换本地时间对比一下。注意，在Java 8以前，一定要牢牢记住时区的名称，不然就会抛出下面的异常：
         */
        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localDateAndTime, america);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);

        /**
         * 示例 13、如何表示信用卡到期这类固定日期，答案就在YearMonth
         * 与 MonthDay检查重复事件的例子相似，YearMonth是另一个组合类，用于表示信用卡到期日、FD到期日、期货期权到期日等。
         * 还可以用这个类得到 当月共有多少天，YearMonth实例的lengthOfMonth()方法可以返回当月的天数，在判断2月有28天还是29天时非常有用。
         * 根据上述数据，你可以提醒客户信用卡快要到期了，个人认为这个类非常有用。
         */
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2020, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);

        /**
         * 示例 14、如何在Java 8中检查闰年
         * LocalDate类有一个很实用的方法isLeapYear()判断该实例是否是一个闰年，如果你还是想重新发明轮子，
         * 这有一个代码示例，纯Java逻辑编写的判断闰年的程序。
         * 你可以多写几个日期来验证是否是闰年，最好是写JUnit单元测试做判断。
         */
        if (today.isLeapYear()) {
            System.out.println(today.getYear() + " This year is Leap year");
        } else {
            System.out.println(today.getYear() + " is not a Leap year");
        }

        /**
         * 示例 15、计算两个日期之间的天数和月数
         * 有一个常见日期操作是计算两个日期之间的天数、周数或月数。在Java 8中可以用java.time.Period类来做计算。
         * 下面这个例子中，我们计算了当天和将来某一天之间的月数。
         * 从上面可以看到现在是一月，Java 8的发布日期是3月，中间相隔两个月。
         */
        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease = Period.between(today, java8Release);
        System.out.println("Months left between today and Java 8 release : "
                + periodToNextJavaRelease.getMonths());

        /**
         * 示例 16、包含时差信息的日期和时间
         * 在Java 8中，ZoneOffset类用来表示时区，举例来说印度与GMT或UTC标准时区相差+05:30，
         * 可以通过ZoneOffset.of()静态方法来 获取对应的时区。一旦得到了时差就可以通过传入
         * LocalDateTime和ZoneOffset来创建一个OffSetDateTime对象。
         * 现在的时间信息里已经包含了时区信息了。注意：OffSetDateTime是对计算机友好的，ZoneDateTime则对人更友好。
         */
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);

        /**
         * 示例 17、在Java 8中获取当前的时间戳
         * 如果你还记得Java 8以前是如何获得当前时间戳，那么现在你终于解脱了。Instant类有一个静态工厂方法now()会返回当前的时间戳，如下所示：
         * 时间戳信息里同时包含了日期和时间，这和java.util.Date很像。实际上Instant类确实等同于 Java 8之前的Date类，
         * 你可以使用Date类和Instant类各自的转换方法互相转换，例如：Date.from(Instant) 将Instant转换成java.util.Date，Date.toInstant()则是将Date类转换成Instant类。
         */
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);

        /**
         * 示例 18、在Java 8中如何使用预定义的格式化工具去解析或格式化日期
         * 在Java 8以前的世界里，日期和时间的格式化非常诡异，唯一的帮助类SimpleDateFormat也是非线程安全的，
         * 而且用作局部变量解析和格式化日期时显得很笨重。幸好线程局部变量能使它在多线程环境中变得可用，不过这都是过去时了。
         * Java 8引入了全新的日期时间格式工具，线程安全而且使用方便。它自带了一些常用的内置格式化工具。下面这个例子
         * 使用了BASIC_ISO_DATE格式化工具将2014年1月14日格式化成2014-01-14。
         * 很明显的看出得到的日期和给出的日期是同一天，但是格式不同。
         */
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n",
                dayAfterTommorrow, formatted);

        /**
         * 示例 19、如何在Java中使用自定义格式化工具解析日期
         * 上个例子使用了Java内置的格式化工具去解析日期字符串。尽管内置格式化工具很好用，有时还是需要定义特定的日期格式，
         * 下面这个例子展示了如何创建自定义 日期格式化工具。例子中的日期格式是“MMM dd yyyy”。可以调用DateTimeFormatter的
         * ofPattern()静态方法并传入任意格式返回其实例，格式中的字符和以前代表的一样，M 代表月，m代表分。如果格式不规范会抛出
         * DateTimeParseException异常，不过如果只是把M写成m这种逻辑错误是不会抛异常的。
         * 日期值与传入的字符串是匹配的，只是格式不同而已。
         */
        String goodFriday = "02 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        /**
         * 示例 20、在Java 8中如何把日期转换成字符串
         * 上两个例子都用到了DateTimeFormatter类，主要是从字符串解析日期。现在我们反过来，
         * 把LocalDateTime日期实例转换成特定格式的字符串。这是迄今为止Java日期转字符串最为简单的方式了。
         * 下面的例子将返回一个代表日期的格式化字符串。和前面类似，还是需要创建 DateTimeFormatter实例
         * 并传入格式，但这回调用的是format()方法，而非parse()方法。这个方法会把传入的日期转化成指定格式的字符串。
         * 当前时间被指定的“MMM dd yyyy hh:mm a”格式格式化，格式包含3个代表月的字符串，时间后面带有AM和PM标记。
         */
        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy  hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at :  %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }

        /*
        Java 8日期时间API的重点
通过这些例子，你肯定已经掌握了Java 8日期时间API的新知识点。现在我们来回顾一下这个优雅API的使用要点：

1）提供了javax.time.ZoneId 获取时区。

2）提供了LocalDate和LocalTime类。

3）Java 8 的所有日期和时间API都是不可变类并且线程安全，而现有的Date和Calendar API中的java.util.Date和SimpleDateFormat是非线程安全的。

4）主包是 java.time,包含了表示日期、时间、时间间隔的一些类。里面有两个子包java.time.format用于格式化， java.time.temporal用于更底层的操作。

5）时区代表了地球上某个区域内普遍使用的标准时间。每个时区都有一个代号，格式通常由区域/城市构成（Asia/Tokyo），在加上与格林威治或 UTC的时差。例如：东京的时差是+09:00。

6）OffsetDateTime类实际上组合了LocalDateTime类和ZoneOffset类。用来表示包含和格林威治或UTC时差的完整日期（年、月、日）和时间（时、分、秒、纳秒）信息。

7）DateTimeFormatter 类用来格式化和解析时间。与SimpleDateFormat不同，这个类不可变并且线程安全，需要时可以给静态常量赋值。 DateTimeFormatter类提供了大量的内置格式化工具，同时也允许你自定义。在转换方面也提供了parse()将字符串解析成日期，如果解析出错会抛出DateTimeParseException。DateTimeFormatter类同时还有format()用来格式化日期，如果出错会抛出DateTimeException异常。

8）再补充一点，日期格式“MMM d yyyy”和“MMM dd yyyy”有一些微妙的不同，第一个格式可以解析“Jan 2 2014”和“Jan 14 2014”，而第二个在解析“Jan 2 2014”就会抛异常，因为第二个格式里要求日必须是两位的。如果想修正，你必须在日期只有个位数时在前面补零，就是说“Jan 2 2014”应该写成 “Jan 02 2014”。

如何使用Java 8的全新日期时间API就介绍到这了。这些简单的例子对帮助理解新API非常有用。由于这些例子都基于真实任务，你在做Java日期编程时不用再东张西望了。我们学会了如何创建并操作日期实例，学习了纯日期、以及包含时间信息和时差信息的日期、学会了怎样计算两个日期的间隔，这些在计算当天与某个特定日期间隔的例子中都有所展示。 我们还学到了在Java 8中如何线程安全地解析和格式化日期，不用再使用蹩脚的线程局部变量技巧，也不用依赖Joda Time第三方库。新API可以作为处理日期时间操作的标准。
         */
    }
}
