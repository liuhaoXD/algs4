package com.liuhao.algs4.solutions.ch1_2;

import edu.princeton.cs.algs4.StdOut;

public class Sol_1_2_16 {
    public final static class Rational {
        private final int numerator;
        private final int denominator;

        public Rational(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Rational plus(Rational b) {
            // 加和减都是将分母统一后，对分子做运算
            return new Rational(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator).reduction();
        }

        public Rational minus(Rational b) {
            return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator).reduction();
        }

        public Rational times(Rational b) {
            return new Rational(numerator * b.numerator, denominator * b.denominator).reduction();
        }

        public Rational divides(Rational b) {
            // 除一个数就是乘它的倒数
            return times(new Rational(b.denominator, b.numerator)).reduction();
        }

        public boolean equals(Rational that) {
            if (that == null) {
                return false;
            }

            return numerator == that.numerator && denominator == that.denominator;
        }

        public String toString() {
            return String.format("%d/%d", numerator, denominator);
        }

        private Rational reduction() {
            int r = gcd(numerator, denominator);
            if (r > 1) {
                return new Rational(numerator / r, denominator / r);
            }
            return this;
        }

        private static int gcd(int p, int q) {
            if (q == 0) {
                return p;
            }
            int r = p % q;
            return gcd(q, r);
        }
    }

    public static void main(String[] args) {
        StdOut.println(new Rational(123, 45));
        StdOut.println(new Rational(1, 2).minus(new Rational(1, 8)));
        StdOut.println(new Rational(1, 2).plus(new Rational(1, 8)));
        StdOut.println(new Rational(3, 4).times(new Rational(2, 3)));
        StdOut.println(new Rational(3, 4).divides(new Rational(2, 3)));
    }
}
