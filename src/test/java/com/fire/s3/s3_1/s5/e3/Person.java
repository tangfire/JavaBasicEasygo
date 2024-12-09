package com.fire.s3.s3_1.s5.e3;

/**
 * 覆写Object方法
 * 因为所有的class最终都继承自Object，而Object定义了几个重要的方法：
 *
 * toString()：把instance输出为String；
 * equals()：判断两个instance是否逻辑相等；
 * hashCode()：计算一个instance的哈希值。
 * 在必要的情况下，我们可以覆写Object的这几个方法。例如：
 */
public class Person {

    private String name;

    public String hello(){
        return "hello";
    }

    // 显示更有意义的字符串:
    @Override
    public String toString() {
        return "Person:name=" + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person类型:
        if (o instanceof Person) {
            Person p = (Person) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}


