package com.practice.leetcode.daily.june25;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestLexicographicalOrder440_9 {

    // MLE
    public int findKthNumber(int n, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i <= 9 ; i++) {
            solve(i, n, result);
        }
        return result.get(k-1);
    }

    public void solve(int curr, int n, List<Integer> result) {
        if (curr > n) return;
        result.add(curr);
        for (int i = 0 ; i <= 9 ; i++) {
            int newNum = (curr * 10) + i;
            solve(newNum, n, result);
        }
    }
}
