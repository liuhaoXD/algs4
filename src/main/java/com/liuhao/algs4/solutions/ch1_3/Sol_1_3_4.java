package com.liuhao.algs4.solutions.ch1_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Sol_1_3_4 {
    public static boolean checkParentheses(String input) {
        Stack<Byte> byteStack = new Stack<>();
        for (byte aByte : input.getBytes()) {
            switch (aByte) {
                case '[':
                case '(':
                case '{':
                    byteStack.push(aByte);
                    break;
                case ']':
                    if (byteStack.isEmpty() || byteStack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (byteStack.isEmpty() || byteStack.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (byteStack.isEmpty() || byteStack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return byteStack.isEmpty();
    }

    public static void main(String[] args) {
        while (true) {
            String input = StdIn.readString();
            if (input.equals("end")) {
                break;
            }
            StdOut.println(checkParentheses(input));
        }
    }
}
