package com.fire.s3.s3_1.s6;

// abstract class

/**
 * 如果一个class定义了方法，但没有具体执行代码，这个方法就是抽象方法，抽象方法用abstract修饰。
 *
 * 因为无法执行抽象方法，因此这个类也必须申明为抽象类（abstract class）。
 *
 * 使用abstract修饰的类就是抽象类。我们无法实例化一个抽象类：
 *
 * 无法实例化的抽象类有什么用？
 *
 * 因为抽象类本身被设计成只能用于被继承，因此，抽象类可以强迫子类实现其定义的抽象方法，否则编译会报错。因此，抽象方法实际上相当于定义了“规范”。
 *
 * 面向抽象编程的本质就是：
 *
 * 上层代码只定义规范（例如：abstract class Person）；
 * 不需要子类就可以实现业务逻辑（正常编译）；
 * 具体的业务逻辑由不同的子类实现，调用者并不关心。
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Student();
        p.run();
    }
}

abstract class Person {
    public abstract void run();
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}