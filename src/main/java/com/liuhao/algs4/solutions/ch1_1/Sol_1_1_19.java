package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class Sol_1_1_19 {

    public static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return F(N - 1) + F(N - 2);
    }

    public static long newF(int N) {
        final List<Long> fibList = new ArrayList<>(256);
        fibList.add(0L);
        fibList.add(1L);

        while (fibList.size() - 1 < N) {
            int i = fibList.size();
            fibList.add(fibList.get(i - 1) + fibList.get(i - 2));
        }
        return fibList.get(N);
    }

    public static void main(String[] args) {
        // 初始化画布
        final int target = 100;
        StdDraw.setXscale(0, target);
        StdDraw.setYscale(0, target * target);
        StdDraw.setPenRadius(.01);

        // 计算 Fibonacci，横轴为 N，纵轴为计算第 N 个 Fibonacci 耗时(ms)
        for (int N = 0; N < 100; N++) {
            long start = System.currentTimeMillis();
            F(N);
            long costTime = System.currentTimeMillis() - start;
            StdDraw.point(N, costTime);

            start = System.currentTimeMillis();
            newF(N);
            costTime = System.currentTimeMillis() - start;
            StdDraw.point(N, costTime);
        }
    }
}
