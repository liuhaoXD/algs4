package com.liuhao.algs4.solutions.ch1_2;

import edu.princeton.cs.algs4.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sol_1_2_1 {

    public static void main(String[] args) {
        StdOut.print("please enter N:");

        int n = StdIn.readInt();
        List<Point2D> pointList = new ArrayList<>(n);

        StdDraw.setXscale(-1, 2);
        StdDraw.setYscale(-1, 2);
        StdDraw.line(-1, 0, 2, 0);
        StdDraw.line(0, -1, 0, 2);

        StdDraw.setPenColor(Color.GREEN);
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < n; i++) {
            pointList.add(new Point2D(StdRandom.uniform(), StdRandom.uniform()));
            StdDraw.point(pointList.get(i).x(), pointList.get(i).y());
        }

        Point2D[] minDistancePoint = new Point2D[2];
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < pointList.size(); i++) {
            for (int j = i + 1; j < pointList.size(); j++) {
                double distance = pointList.get(i).distanceTo(pointList.get(j));
                if (distance < minDistance) {
                    minDistance = distance;
                    minDistancePoint[0] = pointList.get(i);
                    minDistancePoint[1] = pointList.get(j);
                }
            }
        }

        StdDraw.setPenColor(Color.RED);
        StdDraw.point(minDistancePoint[0].x(), minDistancePoint[0].y());
        StdDraw.point(minDistancePoint[1].x(), minDistancePoint[1].y());

        StdOut.printf("min-distance is %.5f", minDistance);
    }
}
