package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_16 {

    public static String exR1(int n) {
        if (n <= 0) {
            return "";
        }
        // 递归计算
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }
}
