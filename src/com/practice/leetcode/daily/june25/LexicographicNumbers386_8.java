package com.practice.leetcode.daily.june25;

import java.util.ArrayList;
import java.util.List;

public class LexicographicNumbers386_8 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i <= 9 ; i++) {
            solve(i, n, result);
        }
        return result;
    }

    public void solve(int curr, int n , List<Integer> result) {
        if (curr > n) return;

        result.add(curr);
        for (int i = 0 ; i <= 9 ; i++) {
            int newNum = (curr * 10) + i;
            if (newNum > n) return;
            solve(newNum, n, result);
        }
    }
}
