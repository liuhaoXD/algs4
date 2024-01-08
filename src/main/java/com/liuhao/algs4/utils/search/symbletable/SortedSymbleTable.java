package com.liuhao.algs4.utils.search.symbletable;

public interface SortedSymbleTable<K extends Comparable<K>, V> extends SymbleTable<K, V> {
    K min();

    K max();

    K floor(K key);

    K ceiling(K key);

    int rank(K key);

    K select(int k);

    default void deleteMin() {
        delete(min());
    }

    default void deleteMax() {
        delete(max());
    }

    default int size(K lo, K hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    @Override
    default Iterable<K> keys() {
        return keys(min(), max());
    }

    Iterable<K> keys(K lo, K hi);
}
