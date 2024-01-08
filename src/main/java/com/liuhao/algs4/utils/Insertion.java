package com.liuhao.algs4.utils;


import edu.princeton.cs.algs4.StdRandom;

/**
 * 交换 N ---- 比较 ~(N^2/2)
 */
public class Insertion {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (ExampleBase.less(a[min], a[j])) {
                    min = j;
                }
            }
            ExampleBase.exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        Integer a[] = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = StdRandom.uniform(-100, 100);
        }
        ExampleBase.show(a);
        sort(a);
        ExampleBase.show(a);
    }
}
