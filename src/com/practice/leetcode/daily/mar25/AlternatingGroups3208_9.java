package com.practice.leetcode.daily.mar25;

import java.util.Collections;

public class AlternatingGroups3208_9 {
    // O(N) sliding window+circular
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int end = n+k-1;
        int left = 0;
        int count = 0;

        for (int right = 1 ; right < end ; right++) {

            if (colors[right%n] == colors[(right-1)%n]) {
                left = right;
            } else if (right-left+1 == k) {
                count++;
                left++;
            }
        }
        return count;
    }
}
