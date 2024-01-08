package com.liuhao.algs4.solutions.ch5;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("WeakerAccess")
public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        this.count = N;
        this.id = new int[N];
        // 初始状态下，每个 id 对应一个元素个数为 1 的连通分量
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    /**
     * p 和 q 是否位于同一个连通分量
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return this.find(p) == this.find(q);
    }

    /**
     * 获取全部连通分量的个数
     *
     * @return
     */
    public int count() {
        return this.count;
    }

    /**
     * 返回 p 所在连通分量的 int 标识
     *
     * @param p
     * @return
     */
    public int find(int p) {
//        return this.quickFindFind(p);
        return this.quickUnionFind(p);
    }

    /**
     * 连接 p q 对应的两个连通分量
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
//        this.quickFindUnion(p, q);
//        this.quickUnionUnion(p, q);
        this.quickUnionWeightedUnion(p, q);
    }

    private int quickFindFind(int p) {
        return id[p];
    }

    private void quickFindUnion(int p, int q) {
        this.count -= 1;
        int pId = this.find(p);
        int qId = this.find(q);
        if (pId == qId) {
            return;
        }
        StdOut.println(p + " " + q);
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    private int quickUnionFind(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    private void quickUnionUnion(int p, int q) {
        this.count -= 1;
        int pRoot = this.find(p);
        int qRoot = this.find(q);
        if (pRoot == qRoot) {
            return;
        }
        StdOut.println(p + " " + q);
        id[pRoot] = qRoot;
    }

    /**
     * sz 保存每个 id 对应分量的树深度
     */
    private int[] sz;

    private void quickUnionWeightedUnion(int p, int q) {
        this.count -= 1;
        int pRoot = this.find(p);
        int qRoot = this.find(q);
        if (pRoot == qRoot) {
            return;
        }
        StdOut.println(p + " " + q);
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while (N != 0) {
            N--;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            uf.union(p, q);
        }
        StdOut.println(uf.count + " components");
    }
}
