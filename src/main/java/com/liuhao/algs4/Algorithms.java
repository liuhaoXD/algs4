package com.liuhao.algs4;


public class Algorithms {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (x == 1) {
            return 1;
        }

        long count = 1;
        double result = x;
        while (true) {
            count *= 2;
            if (count > n) {
                break;
            }
            result *= result;
        }
        count /= 2;
        result *= myPow(x, n - (int) (count));
        return result;
    }
//    2*(((2)*(2))*(2 2))

    public static void main(String[] args) {
        System.out.println(myPow(2, 2)); // 4.00000
        System.out.println(myPow(2, 3)); // 8.00000
        System.out.println(myPow(2, 4)); // 16.00000
        System.out.println(myPow(2, 8)); // 256.00000
        System.out.println(myPow(2, 9)); // 512.00000
        System.out.println(myPow(2, 10)); // 1024.00000
        System.out.println(myPow(2.1, 3)); // 9.26100
        System.out.println(myPow(2, -2)); // 0.25000
        System.out.println(myPow(1.00000, 2147483647)); // 0.25000
    }
}
