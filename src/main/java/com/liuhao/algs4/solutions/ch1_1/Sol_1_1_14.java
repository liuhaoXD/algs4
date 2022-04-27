package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_14 {

    /**
     * 返回不大于 log(2)(N) 的最大整数。
     * x <= log(2)(N) 即 2^x <= N
     */
    public static int lg(int N) {
        int x = 0;
        while ((1 << x) <= N) {
            x++;
        }
        return x - 1;
    }

    public static void main(String[] args) {
        System.out.println(lg(10));
        System.out.println(lg(16));
        System.out.println(lg(32));
        System.out.println(lg(35));
    }
}
