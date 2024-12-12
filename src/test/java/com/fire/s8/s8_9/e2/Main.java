package com.fire.s8.s8_9.e2;

import java.util.*;

/**
 * 把HashSet换成TreeSet，在遍历TreeSet时，输出就是有序的，这个顺序是元素的排序顺序：
 *
 * 使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口，如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象。
 */
public class Main {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        set.add("apple");
        set.add("banana");
        set.add("pear");
        set.add("orange");
        for (String s : set) {
            System.out.println(s);
        }
    }
}

/**
 * 小结
 * Set用于存储不重复的元素集合：
 *
 * 放入HashSet的元素与作为HashMap的key要求相同；
 * 放入TreeSet的元素与作为TreeMap的Key要求相同。
 * 利用Set可以去除重复元素；
 *
 * 遍历SortedSet按照元素的排序顺序遍历，也可以自定义排序算法。
 */