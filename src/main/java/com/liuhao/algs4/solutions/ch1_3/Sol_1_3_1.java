package com.liuhao.algs4.solutions.ch1_3;

import edu.princeton.cs.algs4.StdOut;

public class Sol_1_3_1 {
    public static class FixedCapacityStackOfStrings {
        private final String[] a; // stack entries
        private int N;      // size

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }

        public String pop() {
            return a[--N];
        }

        public boolean isFull() {
            return N == a.length;
        }
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(16);
        stack.push("aa");
        StdOut.println(stack.pop());
        StdOut.println(stack.isFull());
    }
}
