package com.fire.s2.s2_3.s7;

import org.junit.jupiter.api.Test;

public class ArrayType {

    @Test
    public void test01() {
        // 5位同学的成绩:
        int[] ns = new int[5];
        ns[0] = 68;
        ns[1] = 79;
        ns[2] = 91;
        ns[3] = 85;
        ns[4] = 62;

        System.out.println(ns.length);
    }

    @Test
    public void test02() {
        // 5位同学的成绩:
        int[] ns = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns.length); // 编译器自动推算数组大小为5

        // 进一步简写
        int[] nss = {68,78,90,23};
        System.out.println(nss.length);
    }

    /**
     * 如果数组元素不是基本类型，而是一个引用类型，那么，修改数组元素会有哪些不同？
     */
    @Test
    public void test03() {
        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        names[1] = "cat";
        System.out.println(s); // s是"XYZ"还是"cat"?
        System.out.println("--------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
