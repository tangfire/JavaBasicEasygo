package com.fire.s14.s14_3;

import org.junit.jupiter.api.Test;

// 多线程

/**
 * 一个线程还可以等待另一个线程直到其运行结束。
 * 例如，main线程在启动t线程后，可以通过t.join()等待t线程结束后再继续运行：
 * 当main线程对线程对象t调用join()方法时，主线程将等待变量t表示的线程运行结束，即join就是指等待该线程结束，然后才继续往下执行自身线程。
 * 如果t线程已经结束，对实例t调用join()会立刻返回。此外，join(long)的重载方法也可以指定一个等待时间，超过等待时间后就不再继续等待。
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start(); // 启动t线程
        t.join(); // 此处main线程会等待t结束
        System.out.println("end");
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();
        t.join();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}

        System.out.println("main end...");
        t.join();
    }
}

/**
 * 小结
 * Java线程对象Thread的状态包括：New、Runnable、Blocked、Waiting、Timed Waiting和Terminated；
 *
 * 通过对另一个线程对象调用join()方法可以等待其执行结束；
 *
 * 可以指定等待时间，超过等待时间线程仍然没有结束就不再等待；
 *
 * 对已经运行结束的线程调用join()方法会立刻返回。
 */