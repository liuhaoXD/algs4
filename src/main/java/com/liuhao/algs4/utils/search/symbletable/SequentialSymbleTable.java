package com.liuhao.algs4.utils.search.symbletable;

import com.liuhao.algs4.utils.accumulator.Accumulator;
import com.liuhao.algs4.utils.accumulator.TextAccumulator;
import lombok.Getter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SequentialSymbleTable<K, V> implements SymbleTable<K, V> {
    private Node first;

    private int size = 0;

    private final Accumulator accumulator;

    public SequentialSymbleTable(int trials, double max) {
//        accumulator = new VisualAccumulator(trials, max);
        accumulator = new TextAccumulator();
    }

    public Accumulator getAccumulator() {
        return accumulator;
    }

    @Getter
    private class Node {
        private final K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(@Nonnull K key, @Nullable V val) {
        int compareCount = 0;
        for (Node node = first; node != null; node = node.next) {
            compareCount += 1;
            if (key.equals(node.key)) {
                adjustSize(node.value, val);
                node.value = val;
                accumulator.addDataValue(compareCount);
                return;
            }
        }
        accumulator.addDataValue(compareCount);
        first = new Node(key, val, first);
        adjustSize(null, val);
    }

    private void adjustSize(@Nullable V valBefore, @Nullable V valAfter) {
        if (valBefore == null && valAfter != null) {
            size += 1;
        } else if (valBefore != null && valAfter == null) {
            size -= 1;
        }
        // size 不变
    }

//    @Override
//    public void delete(@Nonnull K key) {
//        SymbleTable.super.delete(key);
//
//        //
//        if (first.value == null) {
//            first = first.next;
//        } else {
//            Node lastNode = first;
//            Node curNode = first.next;
//            while (curNode != null) {
//                // 将 value = 0 的 node 从 node list 中删除。
//                if (curNode.value == null) {
//                    lastNode.next = curNode.next;
//                    break;
//                }
//                lastNode = curNode;
//                curNode = curNode.next;
//            }
//        }
//        size -= 1;
//    }

    @Nullable
    @Override
    public V get(@Nonnull K key) {
        for (Node node = first; node != null; node = node.next) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 默认删除时，会将 value 置为 null，但节点仍在 list 中存在
     * 实现 size 的一种方式，是在 value 被 set 为 null 后，即刻将 node 从 list 中删除。
     * 另一种方式，通过 put 方法控制 size，
     * value-before == null，value-after != null 时，size+1
     * value-before != null，value-after == null 时，size-1
     * 其他情况 size 不变
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<K> keys() {
        return () -> new Iterator<K>() {
            Node node = first;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public K next() {
                if (node == null) {
                    throw new NoSuchElementException();
                }
                K key = node.key;
                node = node.next;
                return key;
            }
        };
    }
}
