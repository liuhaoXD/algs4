package com.liuhao.algs4.solutions.ch1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Sol_1_3_2 {
    public static void main(String[] args) {
        String str = "it was - the best - of times - - - it  was - the - -";
        Stack<String> stack = new Stack<>();
        String[] arrStr = str.split("\\s+");
        for (String s : arrStr) {
            if (s.equals("-")) {
                StdOut.println(stack.pop());
            } else {
                stack.push(s);
            }
        }
    }
}
