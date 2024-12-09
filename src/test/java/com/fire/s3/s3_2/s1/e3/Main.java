package com.fire.s3.s3_2.s1.e3;

public class Main {
    public static void main(String[] args) {
        // 是否包含子串:
        System.out.println("Hello".contains("ll")); // true
        System.out.println("Hello".indexOf("l")); // 2
        System.out.println("Hello".lastIndexOf("l"));
        System.out.println("Hello".startsWith("He"));
        System.out.println("Hello".endsWith("lo"));
        System.out.println("Hello".substring(2));
        System.out.println("Hello".substring(2, 4));
    }
}
