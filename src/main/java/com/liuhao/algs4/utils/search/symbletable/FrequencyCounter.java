package com.liuhao.algs4.utils.search.symbletable;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {
    public static void main(String[] args) {

        int minLen = Integer.parseInt(args[0]);

        int maxFrequency = 0;
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<String> totalWords = new LinkedList<>();

        // 初始化，将所有数据读进 map、list
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.length() < minLen) {
                continue;
            }
            totalWords.add(word);
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            if (frequencyMap.get(word) > maxFrequency) {
                maxFrequency = frequencyMap.get(word);
            }
        }

        SequentialSymbleTable<String, Integer> st = new SequentialSymbleTable<>((int) (totalWords.size() * 1.1), frequencyMap.size() * 1.1);
        for (String word : totalWords) {
            if (!st.contains(word)) {
                st.put(word, 1);
            } else {
                st.put(word, st.get(word) + 1);
            }
        }
        StdOut.println(st.getAccumulator());

        String max = " ";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }
        StdOut.println(max + " " + st.get(max));
    }
}
