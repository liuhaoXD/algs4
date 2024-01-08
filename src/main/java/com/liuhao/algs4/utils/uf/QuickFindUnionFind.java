package com.liuhao.algs4.utils.uf;

/**
 * eager algorithm
 * init O(N), union: O(N), connected: O(1)
 * 树结构扁平（只有2层）
 * 最坏情况下，union 时 id 中 N-1 个元素需要修改值
 */
public class QuickFindUnionFind implements UnionFind {
    private final int[] id;
    private int componentCount;

    public QuickFindUnionFind(int n) {
        id = new int[n];
        componentCount = n;
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        // 运行过程中，id[q] 的值可能发生改变，需要提前存下来
        int idP = id[p];
        int idQ = id[q];

        componentCount -= 1;
        for (int i = 0; i < id.length; i++) {
            if (id[i] != idP) {
                continue;
            }
            id[i] = idQ;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return componentCount;
    }
}
