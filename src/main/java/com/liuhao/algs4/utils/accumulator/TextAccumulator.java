package com.liuhao.algs4.utils.accumulator;

public class TextAccumulator extends Accumulator {

    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)

    private double max = Double.MIN_VALUE;

    @Override
    public void addDataValue(double value) {
        n++;
        sum += value;

        if (value > max) {
            max = value;
        }
    }

    @Override
    public double mean() {
        return sum / n;
    }

    @Override
    public int count() {
        return n;
    }

    @Override
    public double max() {
        return max;
    }
}
