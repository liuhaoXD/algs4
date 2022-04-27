package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_17 {

    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        // 收敛条件应该放到递归函数的最开始，否则递归将无法终止
        if (n <= 0) {
            return "";
        }
        return s;
    }


    public static void main(String[] args) {
        // 直接运行会抛出 "java.lang.StackOverflowError" 异常
        exR2(2);
    }
}
