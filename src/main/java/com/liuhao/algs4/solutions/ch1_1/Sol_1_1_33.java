package com.liuhao.algs4.solutions.ch1_1;

import com.liuhao.algs4.utils.test.Assert;

/**
 * TODO
 */
public class Sol_1_1_33 {

    /**
     * vector dot product
     */
    static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new ArithmeticException("vector dimension not match");
        }
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    /**
     * matrix-matrix product
     */
    static double[][] mult(double[][] a, double[][] b) {
        return new double[][]{};
    }

    /**
     * transpose
     */
    static double[][] transpose(double[][] a) {
        if (a.length <= 0) {
            return new double[][]{};
        }
        double[][] result = new double[a[0].length][a.length];

        for (int x = 0; x < a.length; x++) {
            for (int y = 0; y < a[x].length; y++) {
                result[x][y] = a[y][x];
            }
        }
        return result;
    }

    /**
     * matrix-vector product
     */
    static double[] mult(double[][] a, double[] x) {
        double[] result = new double[x.length];
        for (int i = 0; i < a.length; i++) {
            double r = 0;
            for (int j = 0; j < a[i].length; j++) {
                r = r + (a[i][j] * x[j]);
            }
        }
        return new double[]{};
    }

    /**
     * vector-matrix product
     */
    static double[] mult(double[] y, double[][] a) {
        return new double[]{};
    }

    public static void main(String[] args) {
        Assert.assertEquals(32.6, dot(new double[]{1, 2, 3}, new double[]{4, 5, 6.2}));

        Assert.assertEquals(new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        }, transpose(new double[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9},
        }));
    }
}
