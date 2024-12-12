package com.fire.s5.s5_5;

// reflection

import org.junit.jupiter.api.Test;

/**
 * 当我们获取到某个Class对象时，实际上就获取到了一个类的类型：
 *
 * Class cls = String.class; // 获取到String的Class
 * 还可以用实例的getClass()方法获取：
 *
 * String s = "";
 * Class cls = s.getClass(); // s是String，因此获取到String的Class
 * 最后一种获取Class的方法是通过Class.forName("")，传入Class的完整类名获取：
 *
 * Class s = Class.forName("java.lang.String");
 * 这三种方式获取的Class实例都是同一个实例，因为JVM对每个加载的Class只创建一个Class实例来表示它的类型。
 *
 * 获取父类的Class
 * 有了Class实例，我们还可以获取它的父类的Class：
 *
 * 运行上述代码，可以看到，Integer的父类类型是Number，Number的父类是Object，Object的父类是null。除Object外，其他任何非interface的Class都必定存在一个父类类型。
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        System.out.println(o);
        System.out.println(o.getSuperclass());
    }


    /**
     * 获取interface
     * 由于一个类可能实现一个或多个接口，通过Class我们就可以查询到实现的接口类型。例如，查询Integer实现的接口：
     *
     * 运行上述代码可知，Integer实现的接口有：
     *
     * java.lang.Comparable
     * java.lang.constant.Constable
     * java.lang.constant.ConstantDesc
     * 要特别注意：getInterfaces()只返回当前类直接实现的接口类型，并不包括其父类实现的接口类型：
     */
    @Test
    public void test01() {
        Class s = Integer.class;
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }
    }


    /**
     * Integer的父类是Number，Number实现的接口是java.io.Serializable。
     *
     * 此外，对所有interface的Class调用getSuperclass()返回的是null，获取接口的父接口要用getInterfaces()：
     */
    @Test
    public void test02() {
        Class s = Integer.class.getSuperclass();
        Class[] is = s.getInterfaces();
        for (Class i : is) {
            System.out.println(i);
        }

        System.out.println(java.io.DataInputStream.class.getSuperclass()); // java.io.FilterInputStream，因为DataInputStream继承自FilterInputStream
        System.out.println(java.io.Closeable.class.getSuperclass()); // null，对接口调用getSuperclass()总是返回null，获取接口的父接口要用getInterfaces()
        // 如果一个类没有实现任何interface，那么getInterfaces()返回空数组。
    }

    /**
     * 继承关系
     * 当我们判断一个实例是否是某个类型时，正常情况下，使用instanceof操作符：
     */
    @Test
    public void test03() {
        Object n = Integer.valueOf(123);
        boolean isDouble = n instanceof Double; // false
        boolean isInteger = n instanceof Integer; // true
        boolean isNumber = n instanceof Number; // true
        boolean isSerializable = n instanceof java.io.Serializable; // true
    }

    /**
     * 如果是两个Class实例，要判断一个向上转型是否成立，可以调用isAssignableFrom()：
     */
    @Test
    public void test04() {
        // Integer i = ?
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        // Number n = ?
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        // Object o = ?
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        // Integer i = ?
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
    }
}