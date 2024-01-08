package com.liuhao.algs4.utils.other;

import edu.princeton.cs.algs4.StdRandom;


/**
 * 交换 ~(N^2/2) ---- 比较 ~(N^2/2)
 */
public class Bubble {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (ExampleBase.less(a[i], a[j])) {
                    ExampleBase.exch(a, i, j);
                }
            }
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
