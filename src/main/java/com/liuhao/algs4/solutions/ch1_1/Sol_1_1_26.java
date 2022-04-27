package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_26 {

    public static void f(int a, int b, int c) {
        int t;
        if (a > b) {
            t = a;
            a = b;
            b = t;
        }
        // a = min(a,b)
        // b = max(a,b)

        if (a > c) {
            t = a;
            a = c;
            c = t;
        }
        // a = min(a,c)
        // c = max(a,c)
        // 基于前两步，可以得到 a = min(a,b,c)

        if (b > c) {
            t = b;
            b = c;
            c = t;
        }
        // b = min(b,c)
        // c = max(b,c)
        // 前两步结合第三步，可以得到 c = max(a,b,c)

        // 因此有 a <= b <= c
        System.out.printf("a=%d, b=%d, c=%d%n", a, b, c);
    }

    public static void main(String[] args) {
        int a = 5, b = 3, c = 2;
        f(a, b, c);
    }
}
