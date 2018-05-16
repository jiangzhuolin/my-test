package com.jiangzhuolin.thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DaemonThread implements Runnable {
    @Override
    public void run() {
        System.out.println("进入守护线程 => " + Thread.currentThread().getName());

        writeToFile();

        System.out.println("退出守护线程 => " + Thread.currentThread().getName());
    }

    private void writeToFile() {
        File file = new File("/Users/jiangzhuolin/" + File.separator + "daemon.txt" );
        OutputStream os = null;
        try {
            os = new FileOutputStream(file, false);
            int count = 0;
            while (count < 99) {
                os.write(("word " + count + "\r\n").getBytes());
                System.out.println("守护线程 => " + Thread.currentThread().getName() + " 向文件中写入了 word " + count++);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ThreadDaemonDemo {
    /**
     * 从理论上来说，如果守护进程完整执行完成，我们的文件中应该写了 word 0 - 98 的 99 行数据
     * 在此，我为 main 线程设置了一个 5 秒的休眠以防止主线程结束太快不易观察。
     * 由于主线程是唯一的用户线程，因此，一旦主线程退出，则守护线程也结束运行。
     * 那么守护线程将不可能完整的写入 word 0 - 98 的 99 行数据
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("进入主线程 => " + Thread.currentThread().getName());
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("退出主线程 => " + Thread.currentThread().getName());
    }
}
