package com.liuhao.algs4.utils.uf;

/**
 * lazy
 * init: O(N), union: O(N), connected: (N)
 * 树结构较深（最多可能有 N 层）
 */
public class PathCompressionQuickUnionUnionFind implements UnionFind {
    private final int[] id;
    private int componentCount;

    public PathCompressionQuickUnionUnionFind(int n) {
        id = new int[n];
        componentCount = n;

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int idP = find(p);
        int idQ = find(q);
        if (idP == idQ) {
            return;
        }
        componentCount -= 1;
        id[idP] = idQ;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];

            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        return componentCount;
    }
}
