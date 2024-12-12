package com.fire.s6;

import java.lang.reflect.Field;
import java.lang.annotation.*;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person("Jane", 30);
        Person p3 = new Person("sajiodiosadoiusaioduosaudiosauodiusaoiduoiasudiosauoiduasoiudoisauodi", 35);
        
        for (Person person : new Person[]{p1, p2, p3}) {
            try {
                check(person);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void check(Person person) throws IllegalArgumentException {
        for (Field field : person.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                int min = range.min();
                int max = range.max();
                field.setAccessible(true); // 允许访问私有字段

                try {
                    Object value = field.get(person);
                    if (value instanceof String) {
                        String strValue = (String) value;
                        if (strValue.length() < min || strValue.length() > max) {
                            throw new IllegalArgumentException("Invalid value for " + field.getName());
                        }
                    } else if (value instanceof Integer) {
                        int intValue = (Integer) value;
                        if (intValue < min || intValue > max) {
                            throw new IllegalArgumentException("Invalid value for " + field.getName());
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min() default 0;
    int max() default 255;
}

class Person {
    @Range(min = 0, max = 30)
    private String name;
    @Range(min = 0, max = 20)
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}