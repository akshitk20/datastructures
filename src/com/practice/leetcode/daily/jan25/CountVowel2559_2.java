package com.practice.leetcode.daily.jan25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowel2559_2 {

    // brute force
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        for (int i = 0 ; i < queries.length ; i++) {
            int[] indexes = queries[i];
            int count = 0;
            for (int j = indexes[0] ; j <= indexes[1] ; j++) {
                String word = words[j];
                if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    // prefix sum optimized
    /*
    * we look at the lower boundary l - 1 instead of l because the range is inclusive.
    * The prefix sum array represents the cumulative count of vowel strings up to each index.
    * By subtracting prefixSum[l - 1], we ignore all the vowel strings that have appeared before
    * index l in our count and include only those within the range [l, r].
    * */
    public int[] vowelStringsOptimized(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int count = 0;
        int[] prefix = new int[words.length];
        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))) {
                count++;
            }
            prefix[i] = count;
        }

        for (int i = 0 ; i < queries.length ; i++) {
            int[] indexes = queries[i];
            if (indexes[0] == 0) {
                ans[i] = prefix[indexes[1]];
            } else {
                ans[i] = prefix[indexes[1]]-prefix[indexes[0]-1];
            }
        }
        return ans;
    }
}
