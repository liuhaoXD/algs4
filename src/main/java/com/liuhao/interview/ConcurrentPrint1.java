package com.liuhao.interview;

/**
 * 两个或多个线程交替打印数字
 */
public class ConcurrentPrint1 {
    private final int total;

    public ConcurrentPrint1(int total) {
        this.total = total;
    }

    public static void main(String[] args) {
        final ConcurrentPrint1 demo = new ConcurrentPrint1(200);
        Thread t1 = new Thread(demo::print1);
        Thread t2 = new Thread(demo::print2);

        t1.start();
        t2.start();
    }

    public synchronized void print2() {
        for (int i = 1; i <= total; i += 2) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            this.notify(); // notify 当前线程来触发另一个线程的 wait
            try {
                this.wait(); // 等待另一个线程触发 notify
            } catch (InterruptedException e) {
            }
        }
    }

    public synchronized void print1() {
        for (int i = 0; i <= total; i += 2) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
