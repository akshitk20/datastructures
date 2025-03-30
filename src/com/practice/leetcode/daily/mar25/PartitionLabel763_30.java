package com.practice.leetcode.daily.mar25;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel763_30 {

    // O(N) sliding window
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0 ; i < s.length() ; i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }
        int size = 0;
        int end = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            end = Math.max(end, lastIndex[s.charAt(i)-'a']);
            size++;
            if (i == end) {
                result.add(size);
                size = 0;
            }
        }
        return result;
    }
}
