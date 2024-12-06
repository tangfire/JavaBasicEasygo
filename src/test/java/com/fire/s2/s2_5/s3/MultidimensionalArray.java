package com.fire.s2.s2_5.s3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MultidimensionalArray {

    @Test
    public void test01() {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println(ns.length); // 3
    }



    @Test
    public void test02() {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        int[] arr0 = ns[0];
        System.out.println(arr0.length); // 4
    }


    /**
     * 二维数组的每个数组元素的长度并不要求相同
     *
     */
    @Test
    public void test03() {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 }
        };

        for (int[] arr : ns) {
            for (int n: arr){
                System.out.print(n);
                System.out.print(", ");
            }
            System.out.println();
        }
    }


    @Test
    public void test04() {
        int[][] ns = {
                { 1, 2, 3, 4 },
                { 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(Arrays.deepToString(ns));
    }

    /**
     * 三维数组
     */
    @Test
    public void test05() {
        int[][][] ns = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11},
                        {12, 13}
                },
                {
                        {14, 15, 16},
                        {17, 18}
                }
        };
    }


}
