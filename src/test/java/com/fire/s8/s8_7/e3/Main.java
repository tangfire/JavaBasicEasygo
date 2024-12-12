package com.fire.s8.s8_7.e3;

import java.util.*;

/**
 * 这次我们定义了Student类，并用分数score进行排序，高分在前：
 *
 * TreeMap在比较两个Key是否相等时，依赖Key的compareTo()方法或者Comparator.compare()方法。在两个Key相等时，必须返回0
 *
 * 直接借助Integer.compare(int, int)也可以返回正确的比较结果。
 *
 *  注意
 *
 * 使用TreeMap时，对Key的比较需要正确实现相等、大于和小于逻辑！
 *
 * 小结
 * SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；
 *
 * 作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；
 *
 * 要严格按照compare()规范实现比较逻辑，否则，TreeMap将不能正常工作。
 */
public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                if(p1.score == p2.score){
                    return 0;
                }
                return p1.score > p2.score ? -1 : 1;
            }
        });
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Student("Bob", 66))); // 2
    }
}

class Student {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}