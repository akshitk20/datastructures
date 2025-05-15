package com.practice.leetcode.daily.may25;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroup2900_15 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) {
            if (i == 0 || groups[i] != groups[i-1]) {
                result.add(words[i]);
            }
        }
        return result;
    }
}
