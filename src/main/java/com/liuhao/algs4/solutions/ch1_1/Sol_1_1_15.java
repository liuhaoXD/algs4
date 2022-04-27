package com.liuhao.algs4.solutions.ch1_1;

import java.util.Arrays;

public class Sol_1_1_15 {

    /**
     * 返回一个大小为 M 的数组，其中第 i 个元素的值为整数 i 在数组 a 中出现的次数
     */
    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int e : a) {
            if (e >= 0 && e < M) {
                result[e]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 1, 6, 8, 0, 9, 4, 3, 1, 7};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(histogram(a, 10)));
    }

}
