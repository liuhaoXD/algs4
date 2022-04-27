package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_13 {

    private static void printTransposedMatrix(int[][] a) {
        int r = a.length;
        if (r == 0) {
            System.out.print("none");
            return;
        }
        int c = a[0].length;

        // 转置矩阵
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.printf("%d ", a[j][i]);
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {
        printTransposedMatrix(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6}
                }
        );
        printTransposedMatrix(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        );
        printTransposedMatrix(new int[][]
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                        {10, 11, 12}
                }
        );
    }
}
