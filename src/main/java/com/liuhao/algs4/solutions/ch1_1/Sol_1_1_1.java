package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_1 {

    public static void main(String[] args) {
        // a. 整数除法时，结果向下取整，因此 (15 / 2 = 7.5) ==> 7
        System.out.println((0 + 15) / 2);

        // b. 即 0.000002 * 100000000.1
        System.out.println(2.0e-6 * 100000000.1);

        // c. (false || true) ==> true
        System.out.println(true && false || true && true);
    }
}
