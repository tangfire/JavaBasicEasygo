package com.fire.s3.s3_1.s5.e1;

/**
 * 多态: 针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。
 *
 * Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
 *
 * 这个非常重要的特性在面向对象编程中称之为多态。
 */
public class Polymorphic {
    public static void main(String[] args) {
        Person p = new Student();
        p.run();
    }

}


