package com.fire.s8.s8_13;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Stack只有入栈和出栈的操作：
 *
 * 把元素压栈：push(E)；
 * 把栈顶的元素“弹出”：pop()；
 * 取栈顶元素但不弹出：peek()。
 * 在Java中，我们用Deque可以实现Stack的功能：
 *
 * 把元素压栈：push(E)/addFirst(E)；
 * 把栈顶的元素“弹出”：pop()/removeFirst()；
 * 取栈顶元素但不弹出：peek()/peekFirst()。
 * 为什么Java的集合类没有单独的Stack接口呢？因为有个遗留类名字就叫Stack，出于兼容性考虑，所以没办法创建Stack接口，只能用Deque接口来“模拟”一个Stack了。
 *
 * 当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。
 */
public class StackExample {
    public static void main(String[] args) {
        // 使用 LinkedList 作为 Deque 的实现
        Deque<Integer> stack = new LinkedList<>();

        // 压栈操作，类似于 push()
        stack.push(10); // 将 10 压入栈中
        stack.push(20); // 将 20 压入栈中
        stack.push(30); // 将 30 压入栈中

        // 查看栈顶元素，但不弹出，类似于 peek()
        System.out.println("栈顶元素: " + stack.peek()); // 输出 30

        // 弹出栈顶元素，类似于 pop()
        System.out.println("弹出栈顶元素: " + stack.pop()); // 输出并移除 30
        System.out.println("栈顶元素: " + stack.peek()); // 输出 20

        // 弹出栈顶元素，类似于 pop()
        System.out.println("弹出栈顶元素: " + stack.pop()); // 输出并移除 20
        System.out.println("栈顶元素: " + stack.peek()); // 输出 10

        // 弹出栈顶元素，类似于 pop()
        System.out.println("弹出栈顶元素: " + stack.pop()); // 输出并移除 10

        // 栈空时的处理
        if (stack.isEmpty()) {
            System.out.println("栈为空！");
        }
    }
}
