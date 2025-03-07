package com.practice.leetcode.daily.mar25;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeated2965_6 {
    // TC : O(Nsquare) SC : O(N)
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                map.put(grid[i][j] , map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int twice = 0;
        int missing = 0;

        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > 1) {
                twice = key;
                break;
            }
        }
        for (int i = 1 ; i <= n*n ; i++) {
            if (!map.containsKey(i)) {
                missing = i;
                break;
            }
        }
        result[0] = twice;
        result[1] = missing;
        return result;
    }
}
