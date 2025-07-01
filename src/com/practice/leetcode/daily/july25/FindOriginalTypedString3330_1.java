package com.practice.leetcode.daily.july25;

public class FindOriginalTypedString3330_1 {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 0;
        for (int i = 1 ; i < n ; i++) {
            if (word.charAt(i) == word.charAt(i-1)) {
                count++;
            }
        }
        return count+1;
    }
}
