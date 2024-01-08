package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdRandom;

/**
 * ShuffleTest
 */
public class Sol_1_1_36 {

    /**
     * TODO 未完成
     * 通过实验检查表 1.1.10 中的乱序代码是否能够产生预期的效果。
     * 编写一个程序 ShuffleTest，接受命令行参数 M 和 N，将大小为 M 的数组打乱 N 次，且在每次打乱之前都将数组重新初始化为 a[i] = i。
     * 打印一个 M×M 的表格，对于所有的列 j，行 i 表示的是 i 在打乱后 落到 j 的位置的次数。
     * 数组中的所有元素的值都应该接近于 N/M。
     */
    public static void main(String[] args) {
        int m = 100;
        int n = 10;
        System.out.printf("M is %d, N is %d, N/M is %.3f%n", m, n, (double) n / m);

        int[] a = new int[m];
        int shuffleTime = 0;
        do {
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
            }
            StdRandom.shuffle(a);
            shuffleTime++;
        } while (shuffleTime < n);
    }
}
