package com.liuhao.algs4.examples.ch1;

import edu.princeton.cs.algs4.StdDraw;

public class Exp_1_1_20 {
    public static void drawA(int N) {
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i < N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }

    public static void main(String[] args) {
        drawA(100);
    }
}
