package com.fire.s3.s3_2.s6.e1;

// enum

import org.junit.jupiter.api.Test;

/**
 * 为了让编译器能自动检查某个值在枚举的集合内，并且，不同用途的枚举需要不同的类型来标记，不能混用，我们可以使用enum来定义枚举类：
 *
 * enum的比较
 * 使用enum定义的枚举类是一种引用类型。前面我们讲到，引用类型比较，要使用equals()方法，如果使用==比较，它比较的是两个引用类型的变量是否是同一个对象。因此，引用类型比较，要始终使用equals()方法，但enum类型可以例外。
 *
 * 这是因为enum类型的每个常量在JVM中只有一个唯一实例，所以可以直接用==比较：
 */
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }

    @Test
    public void test01() {
       String s = Weekday.SUN.name();// "SUN"

       /**
        * name()
        *
        * 返回常量名
        */
       System.out.println(s);

        /**
         * ordinal()
         *
         * 返回定义的常量的顺序，从0开始计数，例如：
         *
         */
        int n = Weekday.MON.ordinal();
       System.out.println(n);// 1
    }
}

enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}


