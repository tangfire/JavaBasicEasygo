package com.fire.s2.s2_4.s2;

import org.junit.jupiter.api.Test;

public class IfConditionalJudgment {

    /**
     * 条件判断
     */
    @Test
    public void test01() {
        int n = 70;
        if (n >= 60) {
            System.out.println("及格了");
        }
        System.out.println("END");
    }

    @Test
    public void test02() {
        int n = 70;
        if (n >= 90) {
            System.out.println("优秀");
        } else if (n >= 60) {
            System.out.println("及格了");
        } else {
            System.out.println("挂科了");
        }
        System.out.println("END");
    }

    /**
     * 浮点数在计算机中常常无法精确表示，并且计算可能出现误差，因此，判断浮点数相等用==判断不靠谱：
     * 正确的方法是利用差值小于某个临界值来判断：
     */
    @Test
    public void test03() {
        double x = 1 - 9.0 / 10;
        if (x == 0.1) {
            System.out.println("x is 0.1");
        } else {
            System.out.println("x is NOT 0.1");
        }


        double xx = 1 - 9.0 / 10;
        if (Math.abs(xx - 0.1) < 0.00001) {
            System.out.println("xx is 0.1");
        } else {
            System.out.println("xx is NOT 0.1");
        }
    }


    /**
     * 判断引用类型相等
     *
     * 在Java中，判断值类型的变量是否相等，可以使用==运算符。
     * 但是，判断引用类型的变量是否相等，==表示“引用是否相等”，或者说，是否指向同一个对象。
     * 例如，下面的两个String类型，它们的内容是相同的，但是，分别指向不同的对象，用==判断，结果为false：
     *
     * 要判断引用类型的变量内容是否相等，必须使用equals()方法：
     * 注意：执行语句s1.equals(s2)时，如果变量s1为null，会报NullPointerException：
     * 要避免NullPointerException错误，可以利用短路运算符&&：
     * 还可以把一定不是null的对象"hello"放到前面：例如：if ("hello".equals(s)) { ... }。
     */
    @Test
    public void test04() {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }

    @Test
    public void test05() {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1.equals(s2)) {
            System.out.println("s1 equals s2");
        } else {
            System.out.println("s1 not equals s2");
        }
    }

    @Test
    public void test06() {
//        String s1 = null;
//        if (s1.equals("hello")) {
//            System.out.println("hello");
//        }

        // 还可以把一定不是null的对象"hello"放到前面：例如：if ("hello".equals(s)) { ... }。
        String s1 = null;
        if (s1 != null && s1.equals("hello")) {
            System.out.println("hello");
        }
    }

}
