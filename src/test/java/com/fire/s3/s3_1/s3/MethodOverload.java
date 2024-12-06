package com.fire.s3.s3_1.s3;

/**
 * 方法重载
 * 在一个类中，我们可以定义多个方法。如果有一系列方法，它们的功能都是类似的，只有参数有所不同，那么，可以把这一组方法名做成同名方法。
 * 例如，在Hello类中，定义多个hello()方法：
 */
public class MethodOverload {
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.hello();
        hello.hello("tangfire");
        hello.hello("tangfire",17);
    }


}

class Hello {
    public void hello() {
        System.out.println("Hello, world!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public void hello(String name, int age) {
        if (age < 18) {
            System.out.println("Hi, " + name + "!");
        } else {
            System.out.println("Hello, " + name + "!");
        }
    }
}
