package com.liuhao.algs4.solutions.ch1_3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Sol_1_3_6 {

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        StdOut.printf("Before: %s%n", q.toString());

        // 下面的逻辑可以实现将 q 中的元素倒序
        Stack<String> stack = new Stack<String>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());

        StdOut.printf("After: %s", q.toString());
    }
}
