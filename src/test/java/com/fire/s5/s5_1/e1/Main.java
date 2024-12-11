package com.fire.s5.s5_1.e1;

import org.junit.jupiter.api.Test;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 如何获取一个class的Class实例？有三个方法：
     */
    @Test
    public void test01() throws ClassNotFoundException {
        // 方法一：直接通过一个class的静态变量class获取：
        Class cls01 = String.class;
        System.out.println(cls01);

        // 方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取:
        String s = "Hello";
        Class cls02 = s.getClass();
        System.out.println(cls02);


        // 方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls03 = Class.forName("java.lang.String");
        System.out.println(cls03);
        // 因为Class实例在JVM中是唯一的，所以，上述方法获取的Class实例是同一个实例。可以用==比较两个Class实例：
        System.out.println(cls03 == cls02);
    }


    /**
     *
     * 注意一下Class实例比较和instanceof的差别：
     *
     * 用instanceof不但匹配指定类型，还匹配指定类型的子类。而用==判断class实例可以精确地判断数据类型，但不能作子类型比较。
     *
     * 通常情况下，我们应该用instanceof判断数据类型，因为面向抽象编程的时候，我们不关心具体的子类型。只有在需要精确判断一个类型是不是某个class的时候，我们才使用==判断class实例。
     * @throws ClassNotFoundException
     */
    @Test
    public void test02() throws ClassNotFoundException {
        Integer n = new Integer(123);

        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类

        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
        Class c1 = n.getClass();
        Class c2 = Number.class;
        boolean b4 = c1 == c2; // false，因为Integer.class != Number.class
    }


}
