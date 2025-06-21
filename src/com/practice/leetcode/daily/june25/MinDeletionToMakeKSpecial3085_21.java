package com.practice.leetcode.daily.june25;

public class MinDeletionToMakeKSpecial3085_21 {

    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (int i = 0 ; i < word.length() ; i++) {
            freq[word.charAt(i)-'a']++;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 0 ; i < 26 ; i++) {
            int freqI = freq[i];
            int delete = 0;
            for (int j = 0 ; j < 26 ; j++) {
                if (i == j) continue;
                if (freq[j] < freqI) {
                    delete += freq[j];
                } else if (Math.abs(freq[j]-freqI) > k) {
                    delete += Math.abs(freq[j]-freqI-k);
                }
            }
            count = Math.min(count, delete);
        }
        return count;
    }
}
