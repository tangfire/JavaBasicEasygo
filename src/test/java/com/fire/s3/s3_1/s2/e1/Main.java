package com.fire.s3.s3_1.s2.e1;

// 构造方法

/**
 * 由于构造方法是如此特殊，所以构造方法的名称就是类名。
 * 构造方法的参数没有限制，在方法内部，也可以编写任意语句。
 * 但是，和普通方法相比，构造方法没有返回值（也没有void），调用构造方法，必须用new操作符。
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Xiao Ming", 15);
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }
}

class Person {
    private String name;
    private int age;

    public Person(){

    }

    public Person(String name) {
        this.name = name;
        this.age = 12;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}