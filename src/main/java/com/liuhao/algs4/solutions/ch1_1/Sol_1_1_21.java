package com.liuhao.algs4.solutions.ch1_1;

import edu.princeton.cs.algs4.StdIn;

import java.util.HashMap;
import java.util.Map;

public class Sol_1_1_21 {

    /**
     * 编写一段程序，从标准输入按行读取数据，其中每行都包含一个名字和两个整数。
     * 然后用 printf() 打印一张表格,每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数的结果精确到小数点后三位。
     * 可以用这种程序将棒球球手的击球命中率或者学生的考试分数制成表格
     */
    public static void main(String[] args) {

        Map<String, int[]> scoreMap = new HashMap<>();

        while (StdIn.hasNextLine()) {
            String inputLine = StdIn.readLine();
            String[] splitInput = inputLine.split(" ");
            if (splitInput.length != 3) {
                break;
            }

            String userName = splitInput[0].trim();
            int[] scores = new int[]{
                    Integer.parseInt(splitInput[1].trim()),
                    Integer.parseInt(splitInput[2].trim()),
            };
            scoreMap.put(userName, scores);
        }

        for (String userName : scoreMap.keySet()) {
            int[] scores = scoreMap.get(userName);
            System.out.printf("%s\t%d\t%d\t%.3f%n", userName, scores[0], scores[1], (double) scores[0] / scores[1]);
        }
    }
}
