package com.practice.leetcode.daily.jan25;

public class GridGame2017_21 {
    // O(n) : prefix sum technique
    // calculate the sum of the upper row
    // loop and subtract from upper row and add to lower row
    // take min of ans and max of lower and upper
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        long upperRowSum = 0;
        long lowerRowSum = 0;
        for (int i = 0 ; i < grid[0].length ; i++) {
            upperRowSum += grid[0][i];
        }
        for (int i = 0 ; i < grid[0].length ; i++) {
            upperRowSum -= grid[0][i];
            ans = Math.min(ans, Math.max(upperRowSum, lowerRowSum));
            lowerRowSum += grid[1][i];
        }
        return ans;
    }
}
