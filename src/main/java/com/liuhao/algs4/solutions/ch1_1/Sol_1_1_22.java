package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_22 {

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        if (lo > hi) {
            return -1;
        }
        printSpace(depth);
        System.out.printf("%d-%d%n", lo, hi);
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, depth + 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, depth + 1);
        } else {
            return mid;
        }
    }

    private static void printSpace(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("    ");
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(rank(3, a) == 2);
    }
}
