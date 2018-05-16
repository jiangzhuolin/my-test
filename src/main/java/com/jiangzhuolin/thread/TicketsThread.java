package com.jiangzhuolin.thread;

class MyThread1 extends Thread {
    private int count = 5;
    private String name;

    MyThread1(String name) {
        this.name = name;
    }

    public void run() {
        while (count > 0) {
            count --;
            System.out.println(name + " 卖出 1 张票，还剩余 " + count + "张票");
        }
    }
}

public class TicketsThread {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("窗口1");
        MyThread1 thread2 = new MyThread1("窗口2");
        MyThread1 thread3 = new MyThread1("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
