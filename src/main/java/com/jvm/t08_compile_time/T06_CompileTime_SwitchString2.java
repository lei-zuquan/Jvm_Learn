package com.jvm.t08_compile_time;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:03 上午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 编译期处理(语法糖)——switch-string
public class T06_CompileTime_SwitchString2 {
    public T06_CompileTime_SwitchString2() {

    }

    public static void choose(String str) {
        byte x = -1;
        switch (str.hashCode()) {
            case 2123: // hashCode 值可能相同，需要进一步用 equals 比较
                if (str.equals("C.")) {
                    x = 0;
                } else if (str.equals("BM")) {
                    x = 1;
                }
            default:
                switch (x) {
                    case 0:
                        System.out.println("h");
                        break;
                    case 1:
                        System.out.println("w");
                        break;
                }
        }
    }


    public static void choose1(String str) {
        switch (str) {
            case "BM": {
                System.out.println("h");
                break;
            }
            case "C.": {
                System.out.println("w");
                break;
            }
        }
    }



}
