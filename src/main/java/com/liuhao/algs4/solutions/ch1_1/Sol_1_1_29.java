package com.liuhao.algs4.solutions.ch1_1;

import com.liuhao.algs4.utils.test.Assert;

public class Sol_1_1_29 {

    public static class ExtendedBinarySearch {
        public static int indexOf(int[] a, int key) {
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) {
                // Key is in a[lo..hi] or not present.
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]) hi = mid - 1;
                else if (key > a[mid]) lo = mid + 1;
                else return mid;
            }
            return -1;
        }

        public static int count(int[] a, int key) {
            int index = indexOf(a, key);
            if (index < 0) {
                return 0;
            }
            return countDown(a, key, index) + countUpper(a, key, index) + 1;
        }

        public static int countUpper(int[] a, int key, int beginIndex) {
            for (int i = beginIndex; i < a.length; i++) {
                if (a[i] != key) {
                    return (i - 1) - beginIndex;
                }
            }
            return 0;
        }

        public static int countDown(int[] a, int key, int beginIndex) {
            for (int i = beginIndex; i > 0; i--) {
                if (a[i] != key) {
                    return beginIndex - (i + 1);
                }
            }
            return 0;
        }

        public static int rank(int[] a, int key) {
            int index = indexOf(a, key);
            if (index < 0) {
                return 0;
            }
            for (int i = index; i > 0; i--) {
                if (a[i] != key) {
                    return i + 1;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(2, ExtendedBinarySearch.rank(arr, 3));
        Assert.assertEquals(5, ExtendedBinarySearch.countDown(arr, 3, 7));
        Assert.assertEquals(0, ExtendedBinarySearch.countUpper(arr, 3, 7));
        Assert.assertEquals(6, ExtendedBinarySearch.count(arr, 3));
    }
}
