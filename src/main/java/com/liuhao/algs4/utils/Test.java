package com.liuhao.algs4.utils;

import com.liuhao.algs4.utils.accumulator.Accumulator;
import com.liuhao.algs4.utils.accumulator.AccumulatorFactory;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Test {
    public static void main(String[] args) {
        int total = 100;
        Accumulator accumulator = AccumulatorFactory.visual(total, 1);
        for (int i = 0; i < total; i++) {
            accumulator.addDataValue(StdRandom.random());
        }
        StdOut.println(accumulator);
    }
}
