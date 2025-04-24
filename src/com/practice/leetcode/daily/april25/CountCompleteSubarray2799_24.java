package com.practice.leetcode.daily.april25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarray2799_24 {
    // Brute force : O(N^2)
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int count = 0, n = nums.length;

        for (int i = 0 ; i < n ; i++) {
            Set<Integer> set1 = new HashSet<>();
            set1.add(nums[i]);
            if (set1.size() == set.size()) count++;
            for (int j = i+1 ; j < n ; j++) {
                set1.add(nums[j]);
                if (set.size() == set1.size()) {
                    count++;
                }
            }
        }
        return count;
    }

    // TC : O(N) sliding window
    public int countCompleteSubarraysSliding(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int count = set.size();
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;

        for (int left = 0 ; left < n ; left++) {
            if (left > 0) {
                int num = nums[left-1];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) map.remove(num);
            }

            while (right < n && map.size() < count) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                right++;
            }

            if (map.size() == count) ans += n - right + 1;
        }

        return ans;
    }
}
