package com.fire.s3.s3_1.s5.e3;

/**
 * 在子类的覆写方法中，如果要调用父类的被覆写的方法，可以通过super来调用。例如：
 */
public class Student extends Person {
    @Override
    public String hello() {
        // 调佣父类的hello()方法
        return super.hello() + " world";
    }
}
