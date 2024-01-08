package com.liuhao.algs4.utils.test;

import com.liuhao.algs4.utils.search.BruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DataLoader {
    public static int[] largeW() {
        return largeNumbers("algs4-data/largeW.txt");
    }

    public static int[] largeT() {
        return largeNumbers("algs4-data/largeT.txt");
    }

    public static int[] tinyT() {
        return largeNumbers("algs4-data/tinyT.txt");
    }

    public static int[] tinyW() {
        return largeNumbers("algs4-data/tinyW.txt");
    }

    private static int[] largeNumbers(String path) {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);
        Integer[] numbers = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .map(String::trim)
                .map(Integer::parseInt).toArray(Integer[]::new);
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(largeW().length);
        System.out.println(largeT().length);
    }
}
