package com.practice.leetcode.daily.jan25;

public class CountPrefixsuffix3042_8 {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0 ; i < words.length; i++) {
            for (int j = i+1; j < words.length ; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String word1, String word2) {
        return word2.startsWith(word1) && word2.endsWith(word1);
    }
}
