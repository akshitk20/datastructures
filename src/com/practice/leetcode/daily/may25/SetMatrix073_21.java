package com.practice.leetcode.daily.may25;

import java.util.HashSet;
import java.util.Set;

public class SetMatrix073_21 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // rows
        for (int i = 0 ; i < m ; i++) {
            if (rows.contains(i)) {
                for (int j = 0 ; j < n ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // cols
        for (int i = 0 ; i < n ; i++) {
            if (cols.contains(i)) {
                for (int j = 0 ; j < m ; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
