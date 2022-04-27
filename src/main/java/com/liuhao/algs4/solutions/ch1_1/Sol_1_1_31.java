package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 随机连接。编写一段程序，从命令行接受一个整数 N 和 double 值 p(0 到 1 之间)作为参数，
 * 在一个圆上画出大小为 0.05 且间距相等的 N 个点，然后将每对点按照概率 p 用灰线连接。
 */
public class Sol_1_1_31 {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        double p = StdIn.readDouble();
        if (N < 0 || N > 360 || p < 0 || p > 1) {
            return;
        }

        final int r = 50;
        final int circleCenterX = 100;
        final int circleCenterY = 100;

        // initialize canvas
        StdDraw.setXscale(0, 200);
        StdDraw.setYscale(0, 200);

        // draw circle
        StdDraw.circle(circleCenterX, circleCenterY, r);

        // calculate all points' coordinate on circumference of the circle
        List<Point2D> pointOnCircles = new ArrayList<>(N);
        for (int i = 0; i < N; i += 1) {
            pointOnCircles.add(new Point2D(
                    circleCenterX + r * Math.cos(2 * Math.PI * ((double) i / N)),
                    circleCenterY + r * Math.sin(2 * Math.PI * ((double) i / N)))
            );
        }
        if (pointOnCircles.isEmpty()) {
            return;
        }

        // draw points
        StdDraw.setPenRadius(0.05);
        for (Point2D pointOnCircle : pointOnCircles) {
            StdDraw.point(pointOnCircle.x(), pointOnCircle.y());
        }
        // reset pen radius to default
        StdDraw.setPenRadius();

        // calculate if gray lines are needed to be drawn by probability
        List<Point2D[]> grayLines = new LinkedList<>();
        int totalLines = 0;
        for (int i = 0; i < pointOnCircles.size(); i++) {
            for (int j = i + 1; j < pointOnCircles.size(); j++) {
                totalLines++;
                if (Math.random() < p) {
                    grayLines.add(new Point2D[]{pointOnCircles.get(i), pointOnCircles.get(j)});
                }
            }
        }
        if (totalLines <= 0 || grayLines.isEmpty()) {
            return;
        }

        // draw gray lines
        StdDraw.setPenColor(Color.GRAY);
        for (Point2D[] line : grayLines) {
            StdDraw.line(line[0].x(), line[0].y(), line[1].x(), line[1].y());
        }
        StdDraw.setPenColor();

        StdOut.printf("%d of %d (%.3f) lines drawn%n", grayLines.size(), totalLines, ((double) grayLines.size() / totalLines));
    }
}
