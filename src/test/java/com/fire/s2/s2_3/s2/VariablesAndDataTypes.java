package com.fire.s2.s2_3.s2;

import org.junit.jupiter.api.Test;

public class VariablesAndDataTypes {

    /**
     * 定义并打印变量
     */
    @Test
    public void test01() {
        int x = 100; // 定义int类型变量x，并赋予初始值100
        System.out.println(x); // 打印该变量的值
    }

    /**
     * 重新赋值变量
     */
    @Test
    public void test02() {
        int x = 100; // 定义int类型变量x，并赋予初始值100
        System.out.println(x); // 打印该变量的值，观察是否为100
        x = 200; // 重新赋值为200
        System.out.println(x); // 打印该变量的值，观察是否为200
    }

    /**
     * 变量之间的赋值
     */
    @Test
    public void test03() {
        int n = 100; // 定义变量n，同时赋值为100
        System.out.println("n = " + n); // 打印n的值

        n = 200; // 变量n赋值为200
        System.out.println("n = " + n); // 打印n的值

        int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
        System.out.println("x = " + x); // 打印x的值

        x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
        System.out.println("x = " + x); // 打印x的值
        System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？
    }

    /**
     * 定义整型
     */
    @Test
    public void test04() {
        int i = 2147483647;
        int i2 = -2147483648;
        int i3 = 2_000_000_000; // 加下划线更容易识别
        int i4 = 0xff0000; // 十六进制表示的16711680
        int i5 = 0b1000000000; // 二进制表示的512

        long n1 = 9000000000000000000L; // long型的结尾需要加L
        long n2 = 900; // 没有加L，此处900为int，但int类型可以赋值给long
//        int i6 = 900L; // 错误：不能把long型赋值给int
    }

    /**
     * 定义浮点型
     */
    @Test
    public void test05() {
        float f1 = 3.14f;
        float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
//        float f3 = 1.0; // 错误：不带f结尾的是double类型，不能赋值给float

        double d = 1.79e308;
        double d2 = -1.79e308;
        double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324
    }


    /**
     * 定义布尔类型
     */
    @Test
    public void test06() {
        boolean b1 = true;
        boolean b2 = false;
        boolean isGreater = 5 > 3; // 计算结果为true
        int age = 12;
        boolean isAdult = age >= 18; // 计算结果为false
    }


    /**
     * 定义字符类型
     */
    @Test
    public void test07() {
        char a = 'A';
        char zh = '中';
        System.out.println(a);
        System.out.println(zh);
    }

    /**
     * 引用类型
     */
    @Test
    public void test08() {
        String s = "hello";
    }

    /**
     * 常量
     */
    @Test
    public void test09() {
        final double PI = 3.14; // PI是一个常量
        double r = 5.0;
        double area = PI * r * r;
//        PI = 300; // compile error!
    }

    /**
     * var关键字
     * 有些时候，类型的名字太长，写起来比较麻烦。
     * 使用var定义变量，仅仅是少写了变量类型而已。
     */
    @Test
    public void test10() {
        StringBuilder sb = new StringBuilder();

        var sbb = new StringBuilder();
        System.out.println(sbb.getClass().getName());
    }


}
