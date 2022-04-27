package com.liuhao.algs4.solutions.ch1_2;

import edu.princeton.cs.algs4.StdOut;


public class Sol_1_2_7 {

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        // 递归交换左右元素，最终结果是 string reverse
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        StdOut.println(mystery("hello")); // olleh
        StdOut.println(mystery("helloworld")); // dlrowolleh
    }
}
