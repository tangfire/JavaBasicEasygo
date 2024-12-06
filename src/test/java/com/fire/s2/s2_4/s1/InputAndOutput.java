package com.fire.s2.s2_4.s1;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class InputAndOutput {

    /**
     * 输出
     */
    @Test
    public void test01() {
        System.out.print("A,");
        System.out.print("B,");
        System.out.print("C.");
        System.out.println();
        System.out.println("END");
    }


    /**
     * 格式化输出
     * 为什么要格式化输出？因为计算机表示的数据不一定适合人来阅读：
     * 如果要把数据显示成我们期望的格式，就需要使用格式化输出的功能。
     * 格式化输出使用System.out.printf()，通过使用占位符%?，printf()可以把后面的参数格式化成指定格式：
     *
     * n=%d 输出 n 的十进制表示。
     * hex=%08x 输出 n 的十六进制表示，并确保总宽度为 8 个字符，不足时左侧填充 0。
     */
    @Test
    public void test02() {
        double d = 12900000;
        System.out.println(d); // 1.29E7

        double b = 3.14159265358979;
        System.out.printf("%.2f\n", b); // 显示两位小数3.14
        System.out.printf("%.4f\n", b); // 显示4位小数3.1416

        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数
    }


    /**
     * JUnit 测试是自动化的测试框架，它通常不适合用于需要手动交互的代码，像是 Scanner 这种基于控制台输入的操作。
     * JUnit 测试应该是无交互的，即所有的输入和输出都应该是自动化处理的。
     * 因此，使用 Scanner 在标准输入中接收数据会导致测试无法自动化执行。
     *
     */
    @Test
    public void test03() {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }




}
