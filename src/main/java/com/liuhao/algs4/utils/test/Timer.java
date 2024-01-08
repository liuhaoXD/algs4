package com.liuhao.algs4.utils.test;

public class Timer {
    public static long costTime(int times, Runnable task) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            task.run();
        }
        return System.currentTimeMillis() - startTime;
    }
}
