package com.liuhao.algs4.solutions.ch1_2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Sol_1_2_15 {
    public static int[] readInts(String name) throws IOException {
        File file = new File(name);
        String body = new String(Files.readAllBytes(file.toPath()));
        String[] ints = body.split("\\\\s+");
        int[] result = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = Integer.parseInt(ints[i]);
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
