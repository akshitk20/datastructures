package com.practice.leetcode.daily.mar25;

public class MinRecolors2379_8 {
    // TC : O(N) sliding window SC : O(1)
    public int minimumRecolors(String blocks, int k) {
        int right = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        int numWhites = 0;
        int n = blocks.length();
        while (right < n) {
            if (blocks.charAt(right) == 'W') {
                numWhites++;
            }
            if (right-left+1 == k) {
                min = Math.min(min,numWhites);
                if (blocks.charAt(left) == 'W') numWhites--;
                left++;
            }
            right++;
        }
        return min;
    }
}
