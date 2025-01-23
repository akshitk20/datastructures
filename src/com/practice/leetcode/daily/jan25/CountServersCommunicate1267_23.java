package com.practice.leetcode.daily.jan25;

public class CountServersCommunicate1267_23 {

    // O(n*m) : take the count of rows and cols in an array and increment them if it is 1
    // check if count in that array has exceeded 1 if yes then increment result count
    public int countServers(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (grid[i][j] == 1) {
                    ++rows[i];
                    ++cols[j];
                }
            }
        }
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || cols[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }
}
