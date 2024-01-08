package com.liuhao.zuoshen.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 * 当前最优的算法，难点在于每次局部最优能否得到全局最优解
 */
public class A {
    public static void main(String[] args) {
        // 返回所有可能拼接中，字典序最小的结果
        String[] arr;

        // 解法1：将小字符串按字典序排序后，直接拼接。
        arr = new String[]{"aa", "b", "dcdd", "adff"};
        Arrays.sort(arr);
        System.out.println(String.join("", arr));

        arr = new String[]{"ba", "b"};
        Arrays.sort(arr);
        System.out.println(String.join("", arr));

        // 解法2：
        arr = new String[]{"aa", "b", "dcdd", "adff"};
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        System.out.println(String.join("", arr));

        arr = new String[]{"ba", "b"};
        Arrays.sort(arr, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        System.out.println(String.join("", arr));
        // 证明：排序策略具有传递性，a1+a2 <= a2+a1 a2+a3 <= a3+a2 ==> a1+a3 <= a3+a1 ?
    }
}
