package com.liuhao.algs4.utils.uf;

public class UnionFindFactory {
    private UnionFindFactory() {
    }

    public static UnionFind quickFind(int n) {
        return new QuickFindUnionFind(n);
    }

    public static UnionFind quickUnion(int n) {
        return new QuickUnionUnionFind(n);
    }

    public static UnionFind weightedQuickUnion(int n) {
        return new WeightedQuickUnionUnionFind(n);
    }

    public static UnionFind pathCompressionQuickUnion(int n) {
        return new PathCompressionQuickUnionUnionFind(n);
    }

    public static UnionFind pathCompressionWeightedQuickUnion(int n) {
        return new PathCompressionWeightedQuickUnionUnionFind(n);
    }
}
