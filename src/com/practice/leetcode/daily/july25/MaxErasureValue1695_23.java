package com.practice.leetcode.daily.july25;

import java.util.HashSet;

public class MaxErasureValue1695_23 {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        int sum = 0;
        int max = 0;
        int left = 0;
        for (int right = 0 ; right < n ; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(sum, max);
        }
        return max;
    }
}
