package com.liuhao.algs4.solutions.ch1_2;

/**
 * TODO
 */
public class Sol_1_2_19 {
    public static class Date {
        private final int year;
        private final int month;
        private final int day;

        public Date(String date) {
            String[] fields = date.split("/");
            month = Integer.parseInt(fields[0]);
            day = Integer.parseInt(fields[1]);
            year = Integer.parseInt(fields[2]);
        }
    }

    public static void main(String[] args) {
    }
}
