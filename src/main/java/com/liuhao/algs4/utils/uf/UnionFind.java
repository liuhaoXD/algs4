package com.liuhao.algs4.utils.uf;

public interface UnionFind {
    /**
     * connect p and q, which means combine component that
     * contains p with component that contains q into one component
     */
    void union(int p, int q);

    /**
     * where p and q is connected( which means, p and q are in the same component).
     */
    boolean connected(int p, int q);

    /**
     * get identifier of component that contains 'p'
     */
    int find(int p);

    /**
     * number of components
     */
    int count();
}
