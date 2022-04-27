package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_11 {

    public static void printBool2dArray(boolean[][] a) {
        for (int i = 0; i < a.length; i++) {
            // 第一行打印列号
            if (i == 0) {
                System.out.print(" ");
                for (int k = 0; k < a[i].length; k++) {
                    System.out.printf("%d", k);
                }
                System.out.print("\n");
            }

            for (int j = 0; j < a[i].length; j++) {
                // 遍历该行的所有列
                if (j == 0) {
                    // 每一行的第一列打印行号
                    System.out.printf("%d", i);
                }
                // 根据 a[i][j] 的值，打印对应字符
                if (a[i][j]) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        printBool2dArray(
                new boolean[][]{
                        {true, false, false},
                        {false, true, true,},
                        {false, false, true}
                }
        );

        printBool2dArray(
                new boolean[][]{
                        {true, false, false, true},
                        {false, true, true, false},
                        {false, false, true, true}
                }
        );
    }

}
