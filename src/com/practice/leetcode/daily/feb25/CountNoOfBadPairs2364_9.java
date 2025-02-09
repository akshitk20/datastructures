package com.practice.leetcode.daily.feb25;

import java.util.HashMap;
import java.util.Map;

public class CountNoOfBadPairs2364_9 {
    // TC : O(N)
    public long countBadPairs(int[] nums) {
        long totalPairs = 0;
        long goodPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            totalPairs += i;
            goodPairs += map.getOrDefault(i-nums[i],0);
            map.put(i-nums[i], map.getOrDefault(i-nums[i],0)+1);

        }
        return totalPairs - goodPairs;
    }
}
