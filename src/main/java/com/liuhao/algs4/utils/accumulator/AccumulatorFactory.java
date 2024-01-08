package com.liuhao.algs4.utils.accumulator;

public class AccumulatorFactory {
    private AccumulatorFactory() {
    }

    public static Accumulator visual(int trials, double max) {
        return new VisualAccumulator(trials, max);
    }
}
