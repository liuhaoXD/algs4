package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdOut;

public class Sol_1_1_6 {

    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610
            StdOut.println(f);
            f = f + g;
            g = f - g;
            // f, g = f + g, f
            // ==> f[n] = f[n-1] + f[n-2]
        }
    }
}
