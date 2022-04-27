package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.LinkedHashMap;

public class Sol_1_1_39 {

    public static void main(String[] args) {
        int t = StdIn.readInt();

        // 用于保存 t 次执行过程中，不同 N 的条件下，同时存在于两个数组中的整数数量之和
        LinkedHashMap<Integer, Integer> resultMap = new LinkedHashMap<>();
        for (int runTimes = 0; runTimes < t; runTimes++) {
            for (int n = 1000; n <= 1_000_000; n *= 10) {
                int[] arrA = genArr(n);
                int[] arrB = genArr(n);
                // 用于保存当前 N 的条件下，同时存在于两个数组中的整数个数
                int inBothCount = 0;
                for (int key : arrA) {
                    if (BinarySearch.indexOf(arrB, key) >= 0) {
                        inBothCount += 1;
                    }
                }
                // 累加到 resultMap 中
                resultMap.put(n, resultMap.getOrDefault(n, 0) + inBothCount);
            }
        }

        // 输出结果
        System.out.printf("T: %d%n", t);
        resultMap.forEach((k, v) -> System.out.printf("N: %-8d value %.2f %n", k, (double) v / t));
    }

    public static int[] genArr(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = StdRandom.uniform(100_000, 1_000_000);
        }
        return result;
    }
}
