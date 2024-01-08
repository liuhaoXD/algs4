package com.liuhao.algs4.utils.uf;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import lombok.Getter;
import lombok.Setter;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class UnionFindTest {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        List<Tuple<Integer, Integer>> connections = new LinkedList<>();
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            connections.add(new Tuple<>(p, q));
        }

        StdOut.println("init done");

        int repeatTimes = 100;
        UnionFind unionFind = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < repeatTimes; i++) {
//            unionFind = UnionFindFactory.quickFind(n);// mid: 11139ms large: -
//            unionFind = UnionFindFactory.quickUnion(n);// mid: 3000ms large: -
//            unionFind = UnionFindFactory.weightedQuickUnion(n);// mid: 1800ms large: -
//            unionFind = UnionFindFactory.pathCompressionQuickUnion(n);// mid: 940ms/100000 large: 9310ms/100
            unionFind = UnionFindFactory.pathCompressionWeightedQuickUnion(n);// mid: 970ms/100000 large: 10742ms/100
            for (Tuple<Integer, Integer> connection : connections) {
                if (!unionFind.connected(connection.left, connection.right)) {
                    unionFind.union(connection.left, connection.right);
                }
            }
            StdOut.println(i);
        }
        StdOut.printf("repeat cost %dms\n", System.currentTimeMillis() - start);

        StdOut.printf("union has %d components\n", unionFind.count());

        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int componentId = unionFind.find(i);
            nodeMap.computeIfAbsent(componentId, (integer) -> new HashSet<>()).add(i);
        }
        if (false) {
            StdOut.println(nodeMap.entrySet().stream()
                    .map(entry -> new AbstractMap.SimpleEntry<Integer, String>(
                            entry.getKey(),
                            entry.getValue()
                                    .stream().sorted()
                                    .map(Objects::toString)
                                    .collect(Collectors.joining(","))
                    ))
                    .sorted(Comparator.comparing(AbstractMap.SimpleEntry::getKey))
                    .map(integerStringSimpleEntry ->
                            String.format("%s: %s", integerStringSimpleEntry.getKey(), integerStringSimpleEntry.getValue())
                    )
                    .collect(Collectors.joining("\n"))
            );
        }
    }

    @Getter
    @Setter
    private static class Tuple<L, R> {
        private L left;
        private R right;

        public Tuple(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }
}
