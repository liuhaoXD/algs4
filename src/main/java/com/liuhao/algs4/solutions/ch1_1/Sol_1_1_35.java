package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Sol_1_1_35 {

    public static void main(String[] args) {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }
        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

        System.out.printf("original probability distribution is:%n");
        System.out.println(Arrays.toString(dist));
        System.out.println();

        for (int N = 10; ; N *= 10) {
            double[] newDist = new double[2 * SIDES + 1];
            for (int i = 0; i < N; i++) {
                int a = 1 + StdRandom.uniform(6);
                int b = 1 + StdRandom.uniform(6);
                newDist[a + b] += 1.0;
            }
            for (int i = 0; i < newDist.length; i++) {
                newDist[i] = Math.abs((newDist[i] / N));
            }
            System.out.printf("probability distribution of N(%d) is:%n", N);
            System.out.println(Arrays.toString(newDist));
            for (int i = 0; i < newDist.length; i++) {
                newDist[i] -= dist[i];
            }
            double maxProbDelta = Arrays.stream(newDist).max().getAsDouble();
            System.out.printf("max probability delta is %.5f%n", maxProbDelta);
            System.out.println();
            if (maxProbDelta < 0.001) {
                break;
            }
        }
    }

}
