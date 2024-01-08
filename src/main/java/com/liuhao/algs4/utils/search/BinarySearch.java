package com.liuhao.algs4.utils.search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * @author liuhao.x86
 */
public class BinarySearch {

    /**
     * 迭代法
     */
    public static int rankA(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // 被查找的键要么不存在，要么必然存在于a[lo..hi]之中
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > key) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 递归法
     */
    public static int rankB(int key, int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) {
            return -1;
        }
        if (a[mid] < key) {
            return rankB(key, a, mid + 1, hi);
        }
        if (a[mid] > key) {
            return rankB(key, a, lo, mid - 1);
        }
        return mid;
    }

    public static int rank(int key, int[] a) {
        return rankB(key, a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assert rank(3, a) == 2;
        assert rank(1, a) == 0;
        assert rank(10, a) == 9;
        assert rank(11, a) == -1;
        assert rank(0, a) == -1;

        a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assert rank(3, a) == 2;
        assert rank(1, a) == 0;
        assert rank(10, a) == 9;
        assert rank(11, a) == 10;
        assert rank(0, a) == -1;
        assert rank(12, a) == -1;

        System.out.println("ok");

        int[] whiltelist = In.readInts(args[0]);
        Arrays.sort(whiltelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whiltelist) == -1) {
                StdOut.println(key);
            }
        }
    }
}