package com.practice.leetcode.daily.april25;

public class CountSubarrayWithScoreLessThanK2302_28 {

    // O(N) : sliding window
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0, sum = 0;
        int l = 0 , r = 0;
        while (r < n) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
