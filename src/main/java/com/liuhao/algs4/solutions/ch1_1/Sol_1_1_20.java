package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_20 {

    /**
     * 编写一个递归的静态方法计算 ln(N!) 的值
     * log(N!) = log(1 * 2 * 3 * ... * N) = log(1) + log(2) + .. + log(N)
     */
    public static double F(int N) {
        if (N <= 1) {
            return 0;
        }
        return Math.log(N) + F(N - 1);
    }

    public static void main(String[] args) {
        System.out.println(F(1));
        System.out.println(F(3));
        System.out.println(F(10));
    }
}
