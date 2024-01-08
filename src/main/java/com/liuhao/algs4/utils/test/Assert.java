package com.liuhao.algs4.utils.test;

import java.util.Arrays;

public class Assert {
    private Assert() {
    }

    public static void assertTrue(boolean value) {
        assertEquals(true, value);
    }

    public static void assertFalse(boolean value) {
        assertEquals(false, value);
    }

    public static void assertEquals(double left, double right) {
        if (Math.abs(right - left) > 0.00000001) {
            throw new IllegalArgumentException();
        }
    }

    public static void assertEquals(boolean[] left, boolean[] right) {
        if (left.length != right.length) {
            throw new IllegalArgumentException();
        }
        if (!Arrays.equals(left, right)) {
            throw new IllegalArgumentException();
        }
    }

    public static void assertEquals(double[][] left, double[][] right) {
        if (left.length != right.length) {
            throw new IllegalArgumentException();
        }
        int rows = left.length;
        for (int i = 0; i < rows; i++) {
            if (left[i].length != right[i].length) {
                throw new IllegalArgumentException();
            }
            int columns = left[i].length;

            for (int j = 0; j < columns; j++) {
                if (left[i][j] != right[i][j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static void assertEquals(boolean[][] left, boolean[][] right) {
        if (left.length != right.length) {
            throw new IllegalArgumentException();
        }
        int rows = left.length;
        for (int i = 0; i < rows; i++) {
            if (left[i].length != right[i].length) {
                throw new IllegalArgumentException();
            }
            int columns = left[i].length;

            for (int j = 0; j < columns; j++) {
                if (left[i][j] != right[i][j]) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static void assertEquals(boolean expected, boolean given) {
        if (given != expected) {
            throw new IllegalArgumentException();
        }
    }
}
