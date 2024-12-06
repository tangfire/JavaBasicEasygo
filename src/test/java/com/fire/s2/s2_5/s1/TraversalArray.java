package com.fire.s2.s2_5.s1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TraversalArray {

    /**
     * 遍历数组
     */
    @Test
    public void test01(){
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            int n = ns[i];
            System.out.println(n);
        }
    }

    /**
     * 第二种方式是使用for each循环，直接迭代数组的每个元素：
     */
    @Test
    public void test02(){
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }

    /**
     * 遍历数组
     */
    @Test
    public void test03(){
        int[] ns = { 1, 4, 9, 16, 25 };
        System.out.println(Arrays.toString(ns));
    }



}
