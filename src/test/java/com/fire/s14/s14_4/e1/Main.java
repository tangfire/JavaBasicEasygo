package com.fire.s14.s14_4.e1;

// 中断线程

/**
 * 如果线程需要执行一个长时间任务，就可能需要能中断线程。中断线程就是其他线程给该线程发一个信号，该线程收到信号后结束执行run()方法，使得自身线程能立刻结束运行。
 *
 * 我们举个栗子：假设从网络下载一个100M的文件，如果网速很慢，用户等得不耐烦，就可能在下载过程中点“取消”，这时，程序就需要中断下载线程的执行。
 *
 * 中断一个线程非常简单，只需要在其他线程中对目标线程调用interrupt()方法，目标线程需要反复检测自身状态是否是interrupted状态，如果是，就立刻结束运行。
 *
 * 我们还是看示例代码：
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}

/**
 * 仔细看上述代码，main线程通过调用t.interrupt()方法中断t线程，
 * 但是要注意，interrupt()方法仅仅向t线程发出了“中断请求”，至于t线程是否能立刻响应，
 * 要看具体代码。而t线程的while循环会检测isInterrupted()，
 * 所以上述代码能正确响应interrupt()请求，使得自身立刻结束运行run()方法。
 */