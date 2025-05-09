package com.practice.leetcode.daily.feb25;

public class SubArraysOddSum1524_25 {
    // TC : O(N)
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0, prefixSum = 0;
        // redo
        // evenCount starts as one since the initial sum (0) is even
        int oddCount = 0, evenCount = 1;

        for (int num : arr) {
            prefixSum += num;
            // If current prefix sum is even, add the number of odd subarrays
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                // If current prefix sum is odd, add the number of even
                // subarrays
                count += evenCount;
                oddCount++;
            }

            count %= MOD; // To handle large results
        }

        return count;
    }
}
