package com.practice.leetcode.daily.april25;

import java.util.Arrays;

public class CountNumberOfFairPair2563_19 {

    // TC : O(NLogn)
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0 ; i < n ; i++) {
            long low = lowerBound(nums, i+1, n-1, lower-nums[i]);
            long high = lowerBound(nums, i+1 , n-1 , upper-nums[i] + 1);
            count += (high-low);
        }

        return count;
    }

    public long lowerBound(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }
}
