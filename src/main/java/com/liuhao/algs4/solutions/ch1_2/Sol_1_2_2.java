package com.liuhao.algs4.solutions.ch1_2;

import com.liuhao.algs4.utils.test.Assert;
import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol_1_2_2 {

    /**
     * Write an Interval1D client that takes an int value N as command-line argu- ment,
     * reads N intervals (each defined by a pair of double values) from standard input,
     * and prints all pairs that intersect.
     */
    public static void main(String[] args) {
        StdOut.print("please enter N:");

        int n = StdIn.readInt();
        List<Interval1D> intervalList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            StdOut.printf("please enter interval (%d of %d):", i + 1, n);
            String input = StdIn.readString();
            String[] inputDoubles = input.split(",");
            Assert.assertTrue(inputDoubles.length == 2);
            intervalList.add(new Interval1D(Double.parseDouble(inputDoubles[0]), Double.parseDouble(inputDoubles[1])));
        }

        StdDraw.setXscale(
                intervalList.stream().map(Interval1D::min).min(Double::compareTo).get() - 1,
                intervalList.stream().map(Interval1D::max).max(Double::compareTo).get() + 1
        );
        StdDraw.setYscale(-1, (double) n + 1);

        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < intervalList.size(); i++) {
            StdDraw.line(intervalList.get(i).min(), 0.1 * (i + 1), intervalList.get(i).max(), 0.1 * (i + 1));
        }

        for (int i = 0; i < intervalList.size(); i++) {
            for (int j = i + 1; j < intervalList.size(); j++) {
                if (intervalList.get(i).intersects(intervalList.get(j))) {
                    StdOut.printf("%s intersects with %s%n", intervalList.get(i), intervalList.get(j));
                }
            }
        }
    }
}
