package com.fire.s3.s3_1.s4.e4;

/**
 * 向下转型
 *
 * Person类型p1实际指向Student实例，Person类型变量p2实际指向Person实例。在向下转型的时候，把p1转型为Student会成功，因为p1确实指向Student实例，把p2转型为Student会失败，因为p2的实际类型是Person，不能把父类变为子类，因为子类功能比父类多，多的功能无法凭空变出来。
 *
 * 因此，向下转型很可能会失败。失败的时候，Java虚拟机会报ClassCastException。
 */
public class Inherit {
    public static void main(String[] args) {
        Person p1 = new Student(); // upcasting, ok
        Person p2 = new Person();
        Student s1 = (Student) p1; // ok
//        Student s2 = (Student) p2; // runtime error! ClassCastException!


//        为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型：
        Person p = new Person();
        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Student); // false

        Student s = new Student();
        System.out.println(s instanceof Person); // true
        System.out.println(s instanceof Student); // true

        Student n = null;
        System.out.println(n instanceof Student); // false

//        instanceof实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。如果一个引用变量为null，那么对任何instanceof的判断都为false。

//        利用instanceof，在向下转型前可以先判断：

        Person p3 = new Person();
        if(p3 instanceof Student){
            // 只有判断成功才会向下转型:
            Student s3 = (Student) p;// 一定会成功
        }

//        从Java 14开始，判断instanceof后，可以直接转型为指定变量，避免再次强制转型。例如，对于以下代码：
//        这种使用instanceof的写法更加简洁。
//        Object obj = "hello";
//        if (obj instanceof String) {
//            String s3 = (String) obj;
//            System.out.println(s3.toUpperCase());
//        }

        // instanceof variable:
        Object obj = "hello";
        if (obj instanceof String s3) {
            // 可以直接使用变量s:
            System.out.println(s3.toUpperCase());
        }
    }

}
