package com.liuhao.algs4.utils.search.symbletable;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SymbleTableTest {
    public static void main(String[] args) {
        SymbleTable<String, Integer> st = new SymbleTable<String, Integer>() {
            @Override
            public void put(@Nonnull String key, @Nullable Integer val) {

            }

            @Nullable
            @Override
            public Integer get(@Nonnull String key) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterable<String> keys() {
                return null;
            }
        };

        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        for (String s : st.keys()) {
            StdOut.println(s + " " + st.get(s));
        }
    }
}
