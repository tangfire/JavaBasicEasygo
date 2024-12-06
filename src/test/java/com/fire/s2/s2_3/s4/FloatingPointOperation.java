package com.fire.s2.s2_3.s4;

import org.junit.jupiter.api.Test;

public class FloatingPointOperation {

    /**
     * 浮点数运算
     * 由于浮点数存在运算误差，所以比较两个浮点数是否相等常常会出现错误的结果。
     * 正确的比较方法是判断两个浮点数之差的绝对值是否小于一个很小的数：
     */
    @Test
    public void test01() {
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x);
        System.out.println(y);

        // 比较x和y是否相等，先计算其差的绝对值:
        double r = Math.abs(x - y);
        // 再判断绝对值是否足够小:
        if (r < 0.00001) {
            // 可以认为相等
            System.out.println("equal");
        } else {
            // 不相等
            System.out.println("not equal");
        }
    }


}
