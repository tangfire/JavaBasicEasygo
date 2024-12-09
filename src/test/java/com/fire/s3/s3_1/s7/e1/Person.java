package com.fire.s3.s3_1.s7.e1;

/**
 * 在抽象类中，抽象方法本质上是定义接口规范：即规定高层类的接口，从而保证所有子类都有相同的接口实现，这样，多态就能发挥出威力。
 *
 * 如果一个抽象类没有字段，所有方法全部都是抽象方法：
 *
 * 就可以把该抽象类改写为接口：interface。
 *
 * 在Java中，一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个interface
 */
public interface Person {
    void run();
    String getName();
}
