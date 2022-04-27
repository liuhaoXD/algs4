package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdIn;

public class Sol_1_1_24 {

    public static int gcd(int p, int q) {
        System.out.printf("p=%d, q=%d%n", p, q);
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(105, 24));
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        System.out.println(gcd(p, q));
    }
}
