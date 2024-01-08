package com.liuhao.algs4.utils.test;

import edu.princeton.cs.algs4.StdRandom;

public class Random {
    public static void main(String[] args) {
        System.out.println(StdRandom.uniform(4, 32));
        // 根据离散概率随机返回的 int 值(出现 i 的概率为 a[i])
        StdRandom.discrete(new int[]{3});
        StdRandom.shuffle(new int[]{1, 2, 3, 4, 5});
    }
}
