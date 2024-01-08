package com.liuhao.algs4.utils.accumulator;

import edu.princeton.cs.algs4.StdDraw;

public class VisualAccumulator extends Accumulator {
    private int n = 0;          // number of data values
    private double sum = 0.0;   // sample variance * (n-1)

    private double max = Double.MIN_VALUE;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    @Override
    public void addDataValue(double value) {
        n++;
        sum += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, value);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, sum / n);

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
