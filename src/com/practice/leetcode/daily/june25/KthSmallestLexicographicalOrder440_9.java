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

    public int findKthNumberOptimal(int n, int k) {
        int curr = 1;
        k-=1;
        while (k > 0) {
            int count = count(curr, curr+1, n);

            if (count <= k) {
                curr++;
                k -= count; // skipping the element under current prefix
            } else {
                curr *= 10;
                k -= 1;
            }
        }

        return curr;
    }

    public int count(long curr, long next, int n) {
        int count = 0;
        while (curr <= n) {
            count += (next-curr);
            curr = curr * 10;
            next = next * 10;
            next = Math.min(next, (long) n+1);
        }
        return count;
    }
}
