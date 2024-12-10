package com.fire.s3.s3_2.s2;

import org.junit.jupiter.api.Test;

/**
 * 你可能还听说过StringBuffer，这是Java早期的一个StringBuilder的线程安全版本，它通过同步来保证多个线程操作StringBuffer也是安全的，但是同步会带来执行速度的下降。
 *
 * StringBuilder和StringBuffer接口完全相同，现在完全没有必要使用StringBuffer。
 *
 * 注意：对于普通的字符串+操作，并不需要我们将其改写为StringBuilder，因为Java编译器在编译时就自动把多个连续的+操作编码为StringConcatFactory的操作。
 *
 * 在运行期，StringConcatFactory会自动把字符串连接操作优化为数组复制或者StringBuilder操作。
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * Java编译器对String做了特殊处理，使得我们可以直接用+拼接字符串。
     *
     * String s = "";
     * for (int i = 0; i < 1000; i++) {
     *     s = s + "," + i;
     * }
     *
     * 虽然可以直接拼接字符串，但是，在循环中，每次循环都会创建新的字符串对象，然后扔掉旧的字符串。这样，绝大部分字符串都是临时对象，不但浪费内存，还会影响GC效率。
     *
     * 为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，这样，往StringBuilder中新增字符时，不会创建新的临时对象：
     */
    @Test
    public void test01() {
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }
        String s = sb.toString();
        System.out.println(s);
    }

    /**
     * StringBuilder还可以进行链式操作：
     */
    @Test
    public void test02() {
        var sb = new StringBuilder(1024);
        sb.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb.toString());
    }
}
