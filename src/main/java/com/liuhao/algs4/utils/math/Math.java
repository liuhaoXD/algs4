package com.liuhao.algs4.utils.math;

/**
 * @author liuhao.x86
 */
public class Math {
    public static int abs(int x) {
        return x < 0 ? -x : x;
    }

    public static double abs(double x) {
        return x < 0 ? -x : x;
    }

    public static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }

        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算平方根(牛顿迭代法)
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }

        double err = 1e-15;
        double t = c;
        while (abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }

        return t;
    }
}
