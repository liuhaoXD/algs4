package com.liuhao.algs4.utils.accumulator;

public abstract class Accumulator {

    public abstract void addDataValue(double value);

    public abstract double mean();

    public abstract int count();

    public abstract double max();

    @Override
    public String toString() {
        return "n = " + count() + ", mean = " + mean() + ", max = " + max();
    }
}
