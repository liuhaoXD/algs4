package com.liuhao.algs4.solutions.ch1_2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Sol_1_2_4 {
    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1); // world
        StdOut.println(string2); // hello
    }
}
