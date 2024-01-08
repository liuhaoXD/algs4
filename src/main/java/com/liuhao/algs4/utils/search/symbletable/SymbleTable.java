package com.liuhao.algs4.utils.search.symbletable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface SymbleTable<K, V> {

    /**
     * 讲 k-v 对存入表中
     *
     * @param val val 为空时，删除 value
     */
    void put(@Nonnull K key, @Nullable V val);

    /**
     * @return 值不存在时，返回 null
     */
    @Nullable
    V get(@Nonnull K key);

    default void delete(@Nonnull K key) {
        put(key, null);
    }

    default boolean contains(@Nonnull K key) {
        return get(key) != null;
    }

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    Iterable<K> keys();
}
