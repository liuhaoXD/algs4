package com.liuhao.algs4.solutions.ch1_1;

import com.liuhao.algs4.utils.search.BinarySearch;
import com.liuhao.algs4.utils.search.BruteForceSearch;
import com.liuhao.algs4.utils.test.DataLoader;
import com.liuhao.algs4.utils.test.Timer;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sol_1_1_38 {

    public static void main(String[] args) {
//        int[] numberArr = DataLoader.largeW();
        int[] numberArr = DataLoader.largeT();

        Arrays.sort(numberArr);
        System.out.printf("%d~%d (%d in total)%n", numberArr[0], numberArr[numberArr.length - 1], numberArr.length);

        int key = StdRandom.uniform(1000000);
        System.out.printf("search %d%n", key);

        List<Point2D> bruteForceSearch = new LinkedList<>();
        List<Point2D> binarySearch = new LinkedList<>();
        for (int i = 1; i < 1000; i += 100) {
            bruteForceSearch.add(new Point2D(bruteForceSearch.size(), Timer.costTime(i, () -> BruteForceSearch.rank(key, numberArr))));
            binarySearch.add(new Point2D(binarySearch.size(), Timer.costTime(i, () -> BinarySearch.rank(key, numberArr))));
        }
        drawCostTimeLine(bruteForceSearch, binarySearch);
    }

    private static void drawCostTimeLine(List<Point2D> bruteForceSearch, List<Point2D> binarySearch) {
        StdDraw.setXscale(0, bruteForceSearch.size());
        StdDraw.setYscale(-5, 1000);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < bruteForceSearch.size() - 1; i++) {
            StdDraw.line(bruteForceSearch.get(i).x(), bruteForceSearch.get(i).y(), bruteForceSearch.get(i + 1).x(), bruteForceSearch.get(i + 1).y());
        }

        StdDraw.setPenColor(Color.GREEN);
        for (int i = 0; i < binarySearch.size() - 1; i++) {
            StdDraw.line(binarySearch.get(i).x(), binarySearch.get(i).y(), binarySearch.get(i + 1).x(), binarySearch.get(i + 1).y());
        }

        StdDraw.setPenColor();
        StdDraw.setPenRadius(0.008);
        for (Point2D point : bruteForceSearch) {
            StdDraw.point(point.x(), point.y());
        }
        for (Point2D point : binarySearch) {
            StdDraw.point(point.x(), point.y());
        }
    }
}
