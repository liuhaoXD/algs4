package com.liuhao.algs4.solutions.ch1_1;

public class Sol_1_1_27 {

    public static double binomial(int N, int k, double p) {
        if ((N == 0) || (k < 0)) {
            return 1.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }


    /**
     * TODO 二项分布
     * 估计用以下代码计算 binomial(100, 50) 将会产生的递归调用次数
     * <p>
     * 将已经计算过的值保存在数组中并给出一个更好的实现。
     */
    public static void main(String[] args) {
        System.out.println(binomial(100, 50, 0));
    }
}
