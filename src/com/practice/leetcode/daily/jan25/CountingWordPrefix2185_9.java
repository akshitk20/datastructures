package com.practice.leetcode.daily.jan25;

public class CountingWordPrefix2185_9 {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (int i = 0 ; i < words.length; i++) {
            if (words[i].startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
