package com.practice.leetcode.daily.jan25;

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRowCol2661_20 {
    // O(N*M)
    // TODO: do with one hashmap and 2 arrays
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> rowPos = new HashMap<>();
        Map<Integer, Integer> colPos = new HashMap<>();
        Map<Integer, Integer> rowCount = new HashMap<>();
        Map<Integer, Integer> colCount = new HashMap<>();

        for (int i = 0 ; i < mat.length ; i++) {
            for (int j = 0 ; j < mat[0].length ; j++) {
                rowPos.put(mat[i][j], i);
                colPos.put(mat[i][j], j);
            }
        }
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0 ; i < arr.length ; i++) {
            rowCount.put(rowPos.get(arr[i]), rowCount.getOrDefault(rowPos.get(arr[i]), 0) + 1);
            colCount.put(colPos.get(arr[i]), colCount.getOrDefault(colPos.get(arr[i]), 0) + 1);
            if ((rowCount.get(rowPos.get(arr[i])) == m) || (colCount.get(colPos.get(arr[i])) == n)) {
                return i;
            }
        }
        return -1;
    }
}
