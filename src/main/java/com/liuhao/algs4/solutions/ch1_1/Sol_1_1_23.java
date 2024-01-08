package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * TODO
 * Add to the BinarySearch test client the ability to respond to a second argument:
 * + to print numbers from standard input that are not in the whitelist,
 * - to print numbers that are in the whitelist.
 */
public class Sol_1_1_23 {

    public static int rank(int key, int[] a) {
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
     * + 打印出标准输入中不在白名单上的值;
     * - 打印出标准输入中在白名单上的值。
     */
    public static void main(String[] args) {
        Boolean whitelist = null;
        String mark = StdIn.readString();
        switch (mark) {
            case "+":
                whitelist = true;
                break;
            case "-":
                whitelist = false;
                break;
            default:
        }
        if (whitelist == null) {
            System.out.println("whitelist is null");
            return;
        }

        int[] whitelistInts = new In(StdIn.readString()).readAllInts();
        Arrays.sort(whitelistInts);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (whitelist && rank(key, whitelistInts) == -1) {
                StdOut.println(key);
                continue;
            }
            if (!whitelist && rank(key, whitelistInts) != -1) {
                StdOut.println(key);
            }
        }
    }
}
