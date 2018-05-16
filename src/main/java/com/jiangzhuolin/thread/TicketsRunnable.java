package com.jiangzhuolin.thread;

class MyThread2 implements Runnable {
    private int  count = 5;  // 总共 5 张票

    public void run() {
        while (count > 0) {
            count --; // 如果还有票，则卖出一张
            System.out.println(Thread.currentThread().getName() + " 卖出 1 张票，还剩余 " + count + "张票");
        }
    }
}

public class TicketsRunnable {
    public static void main(String[] args) {
        MyThread2 mt1 = new MyThread2();
        MyThread2 mt2 = new MyThread2();
        MyThread2 mt3 = new MyThread2();
        // 创建三个线程模拟三个窗口卖票
        Thread thread1 = new Thread(mt1, "窗口1");
        Thread thread2 = new Thread(mt2, "窗口2");
        Thread thread3 = new Thread(mt3, "窗口3");
        // 启动三个线程，即模拟三个窗口开始卖票
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
