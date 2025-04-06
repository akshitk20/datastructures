package com.practice.leetcode.daily.april25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset368_6 {
    // TC : (N^2) SC : O(N)
    public List<Integer> largestDivisibleSubset(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        int lastIndex = 0;
        int maxI = 1;
        for (int i = 0 ; i < n ; i++) {
            hash[i] = i;
            for (int j = 0 ; j < i ; j++) {
                if ((arr[i] % arr[j] == 0) && (1 + dp[j] > dp[i])) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > maxI) {
                maxI = dp[i];
                lastIndex = i;
            }
        }
        result.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }
        Collections.reverse(result);
        return result;
    }
}
