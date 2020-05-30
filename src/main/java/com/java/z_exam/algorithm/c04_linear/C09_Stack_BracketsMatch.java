package com.java.z_exam.algorithm.c04_linear;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-27 9:20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*

括号匹配问题

给定一个字符串，里边可能包含"()"小括号和其他字符，请编写程序检查该字符串的中的小括号是否成对出现。
例如：
"(上海)(长安)"：正确匹配
"上海((长安))"：正确匹配
"上海(长安(北京)(深圳)南京)":正确匹配
"上海(长安))"：错误匹配
"((上海)长安"：错误匹配


分析：
    1.创建一个栈用来存储左括号
    2.从左往右遍历字符串，拿到每一个字符
    3.判断该字符是不是左括号，如果是，放入栈中存储
    4.判断该字符是不是右括号，如果不是，继续下一次循环
    5.如果该字符是右括号，则从栈中弹出一个元素t；
    6.判断元素t是否为null，如果不是，则证明有对应的左括号，如果不是，则证明没有对应的左括号
    7.循环结束后，判断栈中还有没有剩余的左括号，如果有，则不匹配，如果没有，则匹配
 */
public class C09_Stack_BracketsMatch {
    public static void main(String[] args) {
        String str = "(fdafds(fafds)())";
        boolean match = isMatch(str);
        System.out.println(str + "中的括号是否匹配：" + match);
    }

    /**
     * 判断str中的括号是否匹配
     *
     * @param str 括号组成的字符串
     * @return 如果匹配，返回true，如果不匹配，返回false
     */
    public static boolean isMatch(String str) {
        //1.创建一个栈用来存储左括号
        C09_Stack<String> chars = new C09_Stack<>();
        //2.从左往右遍历字符串，拿到每一个字符
        for (int i = 0; i < str.length(); i++) {
            String currChar = str.charAt(i) + "";
            //3.判断该字符是不是左括号，如果是，放入栈中存储
            if (currChar.equals("(")) {
                chars.push(currChar);
            } else if (currChar.equals(")")) {
                //4.判断该字符是不是右括号，如果不是，继续下一次循 环
                //5.如果该字符是右括号，则从栈中弹出一个元素t；
                String t = chars.pop();
                //6.判断元素t是否为null，如果不是，则证明有对应的左括号，如果不是，则证明没有对应的 左括号
                if (t == null) {
                    return false;
                }
            }
        }
        //7.循环结束后，判断栈中还有没有剩余的左括号，如果有，则不匹配，如果没有，则匹配
        if (chars.size() == 0) {
            return true;
        } else {
            return false;
        }
    }


}
