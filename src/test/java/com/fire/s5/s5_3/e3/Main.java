package com.fire.s5.s5_3.e3;// reflection
import java.lang.reflect.Method;

/**
 * 多态
 * 我们来考察这样一种情况：一个Person类定义了hello()方法，并且它的子类Student也覆写了hello()方法，那么，从Person.class获取的Method，作用于Student实例时，调用的方法到底是哪个？
 *
 * 运行上述代码，发现打印出的是Student:hello，因此，使用反射调用方法时，仍然遵循多态原则：即总是调用实际类型的覆写方法（如果存在）。上述的反射代码：
 *
 * Method m = Person.class.getMethod("hello");
 * m.invoke(new Student());
 * 实际上相当于：
 *
 * Person p = new Student();
 * p.hello();
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // 获取Person的hello方法:
        Method h = Person.class.getMethod("hello");
        // 对Student实例调用hello方法:
        h.invoke(new Student());
    }
}

class Person {
    public void hello() {
        System.out.println("Person:hello");
    }
}

class Student extends Person {
    public void hello() {
        System.out.println("Student:hello");
    }
}