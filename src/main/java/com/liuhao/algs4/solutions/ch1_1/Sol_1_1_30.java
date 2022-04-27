package com.liuhao.algs4.solutions.ch1_1;

import com.liuhao.algs4.utils.array.ArrayUtils;
import edu.princeton.cs.algs4.StdArrayIO;

public class Sol_1_1_30 {

    public static void main(String[] args) {
        StdArrayIO.print(genArr1(10));
        StdArrayIO.print(genArr2(10));
        System.out.println(ArrayUtils.equals(genArr1(10), genArr2(10)));
    }

    /**
     * 逐个计算 a[i][j]
     */
    public static boolean[][] genArr1(int N) {
        boolean[][] a = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = gcd(i, j) == 1;
            }
        }
        return a;
    }

    /**
     * a[i][j] 实际上是等于 a[j][i]
     */
    public static boolean[][] genArr2(int N) {
        boolean[][] a = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                a[i][j] = gcd(i, j) == 1;
                a[j][i] = a[i][j];
            }
        }
        return a;
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

}
