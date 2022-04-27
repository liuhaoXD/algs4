package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_9 {

    /**
     * 使用 Java 内置方法
     */
    public static String integerToBinaryStringA(int N) {
        return Integer.toBinaryString(N);
    }

    /**
     * 教材给出的方法
     */
    public static String integerToBinaryStringB(int N) {
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        return s;
    }

    /**
     * 使用 StringBuilder 优化教材给出的方法性能，通过 "+" 拼接字符串存在严重的性能问题
     */
    public static String integerToBinaryStringC(int N) {
        StringBuilder s = new StringBuilder();
        for (int n = N; n > 0; n /= 2) {
            s.insert(0, (n % 2));
        }
        return s.toString();
    }

    /**
     * 除 2 取余，逆序排列，得到二进制结果，其实和 B 相同
     */
    public static String integerToBinaryStringD(int N) {
        StringBuilder sb = new StringBuilder();
        for (; N > 0; N /= 2) {
            sb.append(N % 2);
        }
        return sb.reverse().toString();
    }

    private static void test(int N) {
        System.out.println(integerToBinaryStringA(N));
        System.out.println(integerToBinaryStringB(N));
        System.out.println(integerToBinaryStringC(N));
        System.out.println(integerToBinaryStringD(N));
    }

    public static void main(String[] args) {
        test(65535);
        test(0b0101_1010_1111_0000);
    }
}
