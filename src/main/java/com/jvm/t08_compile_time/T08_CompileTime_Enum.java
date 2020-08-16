//package com.jvm.t08_compile_time;
//
///**
// * @Author: Lei
// * @E-mail: 843291011@qq.com
// * @Date: Created in 11:47 上午 2020/8/16
// * @Version: 1.0
// * @Modified By:
// * @Description:
// */
//
//// 编译期处理(语法糖)——Enum
////enum Sex {
////    MALE, FEMALE;
////}
//
//public final class Sex extends Enum<Sex> {
//    public static final Sex MALE;
//    public static final Sex FEMALE;
//    private static final Sex[] $VALUES;
//
//    static {
//        MALE = new Sex("MALE", 0);
//        FEMALE = new Sex("FEMALE", 1);
//        $VALUES = new Sex[]{MALE, FEMALE};
//    }
//    /**
//     * Sole constructor. Programmers cannot invoke this constructor.
//     * It is for use code emitted by the compiler in response to
//     * enum type declarations.
//     *
//     * @param name - The name of this enum constant, which is the identifier used to declare it.
//     * @param ordinal - The ordinal of this enumeration constant (its position in the enum declaration, where the initial constant is assigned
//     */
//    private Sex(String name, int ordinal) {
//        super(name, ordinal);
//    }
//
//    public static Sex[] values() {
//        return $VALUES.clone();
//    }
//
//    public static Sex valueOf(String name) {
//        return Enum.valueOf(Sex.class, name);
//    }
//}
//
//public class T08_CompileTime_Enum {
//    /**
//     * 定义一个合成类（仅 jvm 使用，对我们不可见）
//     * 用来映射枚举的 ordinal 与数组元素的关系
//     * 枚举的 ordinal 表示枚举对象的序号，从 0 开始
//     * 即 MALE 的 ordinal()=0, FEMALE 的 ordinal()=1
//     */
//    static class $MAP {
//        // 数组大小即为枚举元素个数，里面存储case用来对比的数字
//        static int[] map = new int[2];
//        static {
//            map[Sex.MALE.ordinal()] = 1;
//            map[Sex.FEMALE.ordinal()] = 2;
//        }
//    }
//
//    public static void foo(Sex sex){
//        int x = $MAP.map[sex.ordinal()];
//        switch (x) {
//            case 1:{
//                System.out.println("男");
//                break;
//            }
//            case 2:{
//                System.out.println("女");
//                break;
//            }
//        }
//    }
//
//
//}
