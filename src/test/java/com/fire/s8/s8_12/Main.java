package com.fire.s8.s8_12;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque实现了一个双端队列（Double Ended Queue），它可以：
 *
 * 将元素添加到队尾或队首：addLast()/offerLast()/addFirst()/offerFirst()；
 * 从队首／队尾获取元素并删除：removeFirst()/pollFirst()/removeLast()/pollLast()；
 * 从队首／队尾获取元素但不删除：getFirst()/peekFirst()/getLast()/peekLast()；
 * 总是调用xxxFirst()/xxxLast()以便与Queue的方法区分开；
 * 避免把null添加到队列。
 *
 * Queue提供的add()/offer()方法在Deque中也可以使用，但是，使用Deque，最好不要调用offer()，而是调用offerLast()：
 * 如果直接写deque.offer()，我们就需要思考，offer()实际上是offerLast()，我们明确地写上offerLast()，不需要思考就能一眼看出这是添加到队尾。
 *
 * 因此，使用Deque，推荐总是明确调用offerLast()/offerFirst()或者pollFirst()/pollLast()方法。
 *
 * Deque是一个接口，它的实现类有ArrayDeque和LinkedList。
 * 我们发现LinkedList真是一个全能选手，它即是List，又是Queue，还是Deque。但是我们在使用的时候，总是用特定的接口来引用它，这是因为持有接口说明代码的抽象层次更高，而且接口本身定义的方法代表了特定的用途。
 *
 * // 不推荐的写法:
 * LinkedList<String> d1 = new LinkedList<>();
 * d1.offerLast("z");
 * // 推荐的写法：
 * Deque<String> d2 = new LinkedList<>();
 * d2.offerLast("z");
 * 可见面向抽象编程的一个原则就是：尽量持有接口，而不是具体的实现类。
 */
public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // A <- B
        deque.offerFirst("C"); // C <- A <- B
        System.out.println(deque.pollFirst()); // C, 剩下A <- B
        System.out.println(deque.pollLast()); // B, 剩下A
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}