package com.liuhao.algs4.utils.array;

public class ArrayUtils {
    public static boolean equals(boolean[][] left, boolean[][] right) {
        if (left.length != right.length) {
            return false;
        }
        int rows = left.length;
        for (int i = 0; i < rows; i++) {
            if (left[i].length != right[i].length) {
                return false;
            }
            int columns = left[i].length;

            for (int j = 0; j < columns; j++) {
                if (left[i][j] != right[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean equals(int[][] left, int[][] right) {
        if (left.length != right.length) {
            return false;
        }
        int rows = left.length;
        for (int i = 0; i < rows; i++) {
            if (left[i].length != right[i].length) {
                return false;
            }
            int columns = left[i].length;

            for (int j = 0; j < columns; j++) {
                if (left[i][j] != right[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
