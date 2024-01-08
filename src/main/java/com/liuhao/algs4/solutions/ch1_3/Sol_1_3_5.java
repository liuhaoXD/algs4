package com.liuhao.algs4.solutions.ch1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Sol_1_3_5 {

    public static void main(String[] args) {
        // 程序实现的是打印 N 的二进制表示，等效于 Integer.toBinaryString
        int N = 50;
        StdOut.println(Integer.toBinaryString(N));

        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
