package com.fire.s3.s3_1.s7.e1;


public class Student implements Person{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {

    }

    @Override
    public String getName() {
        return this.name;
    }
}
