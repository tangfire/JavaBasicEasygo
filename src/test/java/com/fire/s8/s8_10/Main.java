package com.fire.s8.s8_10;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在Java的标准库中，队列接口Queue定义了以下几个方法：
 *
 * int size()：获取队列长度；
 * boolean add(E)/boolean offer(E)：添加元素到队尾；
 * E remove()/E poll()：获取队首元素并从队列中删除；
 * E element()/E peek()：获取队首元素但并不从队列中删除。
 * 对于具体的实现类，有的Queue有最大队列长度限制，有的Queue没有。注意到添加、删除和获取队列元素总是有两个方法，这是因为在添加或获取元素失败时，这两个方法的行为是不同的。
 * 我们用一个表格总结如下：
 *
 *                   throw Exception	 返回false或null
 * 添加元素到队尾	     add(E e)	         boolean offer(E e)
 * 取队首元素并删除	 E remove()	         E poll()
 * 取队首元素但不删除	 E element()	     E peek()
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 假设我们有一个队列，对它做一个添加操作，如果调用add()方法，当添加失败时（可能超过了队列的容量），它会抛出异常：
     */
    @Test
    public void test01() {
        Queue<String> q = new LinkedList<>();
        try {
            q.add("Apple");
            System.out.println("添加成功");
        } catch(IllegalStateException e) {
            System.out.println("添加失败");
        }
    }

    /**
     * 如果我们调用offer()方法来添加元素，当添加失败时，它不会抛异常，而是返回false：
     */
    @Test
    public void test02() {
        Queue<String> q = new LinkedList<>();
        if (q.offer("Apple")) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    /**
     * 当我们需要从Queue中取出队首元素时，如果当前Queue是一个空队列，调用remove()方法，它会抛出异常：
     */
    @Test
    public void test03() {
        Queue<String> q = new LinkedList<>();
        try {
            String s = q.remove();
            System.out.println("获取成功");
        } catch(IllegalStateException e) {
            System.out.println("获取失败");
        }
    }

    /**
     * 如果我们调用poll()方法来取出队首元素，当获取失败时，它不会抛异常，而是返回null：
     *
     * 注意：不要把null添加到队列中，否则poll()方法返回null时，很难确定是取到了null元素还是队列为空。
     */
    @Test
    public void test04() {
        Queue<String> q = new LinkedList<>();
        String s = q.poll();
        if (s != null) {
            System.out.println("获取成功");
        } else {
            System.out.println("获取失败");
        }
    }

    @Test
    public void test05() {
        Queue<String> q = new LinkedList<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // 队首永远都是apple，因为peek()不会删除它:
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
        System.out.println(q.peek()); // apple
    }

}

/**
 * 小结
 * 队列Queue实现了一个先进先出（FIFO）的数据结构：
 *
 * 通过add()/offer()方法将元素添加到队尾；
 * 通过remove()/poll()从队首获取元素并删除；
 * 通过element()/peek()从队首获取元素但不删除。
 * 要避免把null添加到队列。
 */
