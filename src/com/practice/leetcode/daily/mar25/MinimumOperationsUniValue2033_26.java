package com.practice.leetcode.daily.mar25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumOperationsUniValue2033_26 {
    // Tc : O(mnlogmn) + O(m*n)
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int val = grid[0][0] % x;

        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
        for (int i = 0 ; i < list.size() ; i++) {
            if ((list.get(i) % x) != val) return -1;
        }

        int len = list.size();
        int num = list.get(len/2);
        int result = 0;
        for (int n : list) {
            result += Math.abs(num-n) / x;
        }
        return result;
    }
}
