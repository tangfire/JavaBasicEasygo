package com.fire.s3.s3_1.s4.e2;

/**
 * 如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
 *
 * 在Java中，任何class的构造方法，第一行语句必须是调用父类的构造方法。如果没有明确地调用父类的构造方法，编译器会帮我们自动加一句super();
 *
 * 即子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
 */
public class Main {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 12, 89);
        System.out.println(s.getName());
        System.out.println(s.getAge());
        System.out.println(s.getScore());
    }
}
