
package com.liuhao.algs4.utils.uf;

import java.util.HashSet;
import java.util.Set;

/**
 * lazy
 * init: O(N), union: O(lgN), connected: (lgN)
 * 树结构较浅（最多可能有 lgN 层）
 */
public class WeightedQuickUnionUnionFind implements UnionFind {
    private final int[] id;
    private final int[] sz;
    private int componentCount;

    public WeightedQuickUnionUnionFind(int n) {
        id = new int[n];
        sz = new int[n];
        componentCount = n;

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            sz[i] = 0;
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
        if (sz[idP] < sz[idQ]) {
            id[idP] = idQ;
            sz[idQ] += sz[idP];
        } else {
            id[idQ] = idP;
            sz[idP] += sz[idQ];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    @Override
    public int count() {
        Set<Integer> idSet = new HashSet<>();
        for (int i = 0; i < id.length; i++) {
            if (id[i] == i) {
                idSet.add(i);
            }
        }
        return idSet.size();
    }
}
