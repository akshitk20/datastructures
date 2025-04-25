package com.practice.leetcode.daily.april25;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfInterestingSubarray2845_25 {

    // BF : O(N^2)
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0 ; i < n ; i++) {
            int count = 0;
            for (int j = i ; j < n ; j++) {
                if (nums.get(j) % modulo == k) {
                    count++;
                }
                if (count % modulo == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public long countInterestingSubarraysON(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> remainderFreq = new HashMap<>();
        remainderFreq.put(0, 1L);  // base case: prefix with 0 interesting elements
        long result = 0;
        int count = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }

            int currentRemainder = count % modulo;

            // We want (currentRemainder - k + modulo) % modulo
            int target = (currentRemainder - k + modulo) % modulo;

            result += remainderFreq.getOrDefault(target, 0L);

            remainderFreq.put(currentRemainder, remainderFreq.getOrDefault(currentRemainder, 0L) + 1);
        }
        return result;
    }
}
