package com.fire.s5.s5_2.e2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 一个Field对象包含了一个字段的所有信息：
 *
 * getName()：返回字段名称，例如，"name"；
 * getType()：返回字段类型，也是一个Class实例，例如，String.class；
 * getModifiers()：返回字段的修饰符，它是一个int，不同的bit表示不同的含义。
 * 以String类的value字段为例，它的定义是：
 *
 * public final class String {
 *     private final byte[] value;
 * }
 * 我们用反射获取该字段的信息，代码如下：
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Field f = String.class.getDeclaredField("value");
        System.out.println(f.getName()); // "value"
        System.out.println(f.getType()); // class [B 表示byte[]类型
        int m = f.getModifiers();
        Modifier.isFinal(m); // true
        Modifier.isPublic(m); // false
        Modifier.isProtected(m); // false
        Modifier.isPrivate(m); // true
        Modifier.isStatic(m); // false
    }

}
