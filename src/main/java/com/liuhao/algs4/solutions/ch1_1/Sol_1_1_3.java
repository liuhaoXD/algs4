package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Sol_1_1_3 {
    public static void main(String[] args) {

        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();

        if (a == b && b == c) {
            StdOut.println("equal");
            return;
        }
        StdOut.println("not equal");
    }
}
