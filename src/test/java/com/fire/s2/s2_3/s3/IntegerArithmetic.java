package com.fire.s2.s2_3.s3;

import org.junit.jupiter.api.Test;

public class IntegerArithmetic {

    /**
     * 四则运算
     */
    @Test
    public void test01() {
        int i = (100 + 200) * (99 - 88); // 3300
        int n = 7 * (5 + (i - 9)); // 23072
        System.out.println(i);
        System.out.println(n);
    }
}
