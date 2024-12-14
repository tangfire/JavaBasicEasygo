package com.fire.s2.s2_7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] tmp = arr;
        tmp[3] = 100;
        for (int i:arr){
            System.out.println(i);
        }
    }

    @Test
    public void test02() {

            int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            int[] tmp = arr.clone();  // 创建数组 arr 的副本
            tmp[3] = 100;  // 修改 tmp 数组
            for (int i : arr) {
                System.out.println(i);  // 输出原数组，原数组不受影响
            }
    }


    @Test
    public void test03() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] tmp = Arrays.copyOf(arr, arr.length);  // 创建数组 arr 的副本
        tmp[3] = 100;  // 修改 tmp 数组
        for (int i : arr) {
            System.out.println(i);  // 输出原数组，原数组不受影响
        }
    }


}
