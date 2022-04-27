package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdOut;

public class Sol_1_1_5 {

    public static boolean isBetween0and1(double n) {
        return (n > 0 && n < 1);
    }

    public static void isBetween0and1(double x, double y) {
        if (isBetween0and1(x) && isBetween0and1(y)) {
            StdOut.println("true");
        } else {
            StdOut.println("false");
        }
    }

    public static void main(String[] args) {
        isBetween0and1(1, 3);
        isBetween0and1(0.3, 0.4);
        isBetween0and1(0.3, -0.4);
        isBetween0and1(0.1, 0.8);
        isBetween0and1(-2, 0.9);
        isBetween0and1(0.9999999999, 0.999999999999999);
        isBetween0and1(0.0000000000001, 0.00000000000001);
    }
}
