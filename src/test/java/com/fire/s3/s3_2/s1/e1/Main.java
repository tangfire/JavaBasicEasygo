package com.fire.s3.s3_2.s1.e1;

// String

/**
 * 在Java中，String是一个引用类型，它本身也是一个class。但是，Java编译器对String有特殊处理，即可以直接用"..."来表示一个字符串：
 *
 * String s1 = "Hello!";
 * 实际上字符串在String内部是通过一个char[]数组表示的，因此，按下面的写法也是可以的：
 *
 * String s2 = new String(new char[] {'H', 'e', 'l', 'l', 'o', '!'});
 * 因为String太常用了，所以Java提供了"..."这种字符串字面量表示方法。
 *
 * Java字符串的一个重要特点就是字符串不可变。这种不可变性是通过内部的private final char[]字段，以及没有任何修改char[]的方法实现的。
 */
public class Main {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(s);
        s = s.toUpperCase();
        System.out.println(s);
    }
}