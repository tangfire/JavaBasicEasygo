package com.fire.s2.s2_4.s5;

import org.junit.jupiter.api.Test;

public class DoWhileLoop {

    @Test
    public void test01() {
        int sum = 0;
        int n = 1;
        do {
            sum = sum + n;
            n ++;
        } while (n <= 100);
        System.out.println(sum);
    }

}
