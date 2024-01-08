package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.Arrays;

/**
 * TODO
 */
public class Sol_1_1_32 {

    public static void main(String[] args) {
//        int N = Integer.parseInt(args[1]);
//        double l = Double.parseDouble(args[2]);
//        double r = Double.parseDouble(args[3]);
//
//        double[] values = StdIn.readAllDoubles();

        int N = 5;
        double l = 2;
        double r = 5;
        double[] values = new double[]{1.3, 2.2, 2.4, 2.5, 2.7, 3.2, 3.3, 3.9, 4.5, 4.8, 5.1};
        double delta = (r - l) / N;
        int[] histogram = new int[N];
        for (double value : values) {
            if (value < l || value > r) {
                continue;
            }
            histogram[(int) ((value - l) / delta)] += 1;
        }
        System.out.println(Arrays.toString(histogram));
        StdDraw.setXscale(-1, r + 5);
        StdDraw.setYscale(-1, Arrays.stream(values).max().getAsDouble() + 5);
        StdDraw.line(0, -1, 0, Arrays.stream(values).max().getAsDouble() + 5);
        StdDraw.line(-1, 0, r + 5, 0);

        // 直方图的宽度和间距依赖于 N 的取值和 delta
        for (int i = 0; i < histogram.length; i++) {
            StdDraw.setPenColor(i % 2 == 0 ? Color.RED : Color.GREEN);
            StdDraw.filledRectangle(l + (i * delta) * 2, 0.5 * histogram[i], 0.6, 0.5 * histogram[i]);
            System.out.println(l + (i * delta) * 2);
        }
        StdDraw.setPenColor();
        for (int i = 0; i <= histogram.length; i++) {
            StdDraw.text(l + (i * delta) * 2 - 0.7, -0.3, Double.toString(l + (i * delta)), 0.1);
        }

    }
}
