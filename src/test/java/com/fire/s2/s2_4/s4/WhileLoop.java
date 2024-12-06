package com.fire.s2.s2_4.s4;

import org.junit.jupiter.api.Test;

public class WhileLoop {

    @Test
    public void test01() {
        int sum = 0; // 累加的和，初始化为0
        int n = 1;
        while (n <= 100) { // 循环条件是n <= 100
            sum = sum + n; // 把n累加到sum中
            n ++; // n自身加1
        }
        System.out.println(sum); // 5050
    }

    /**
     * 如果循环条件的逻辑写得有问题，也会造成意料之外的结果：
     * 表面上看，上面的while循环是一个死循环，但是，Java的int类型有最大值，达到最大值后，再加1会变成负数，结果，意外退出了while循环。
     *
     */
    @Test
    public void test02() {
        int sum = 0;
        int n = 1;
        while (n > 0) {
            sum = sum + n;
            n ++;
        }
        System.out.println(n); // -2147483648
        System.out.println(sum);
    }

}
