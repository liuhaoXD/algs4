package com.liuhao.algs4.solutions.ch1_2;

import edu.princeton.cs.algs4.StdOut;


public class Sol_1_2_8 {
    public static void main(String[] args) {
        int[] a = new int[1000];
        int[] b = new int[1000];
        StdOut.printf("a: %s, b: %s%n", a, b);
        int[] t = a;
        a = b;
        b = t;
        StdOut.printf("a: %s, b: %s%n", a, b);
        StdOut.println("only references are swapped");
    }
}
