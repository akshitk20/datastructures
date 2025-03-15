package com.practice.leetcode.daily.mar25;

public class HouseRobberIV2560_15 {
    // binary search on ranges
    // TC : nlogm
    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        int low = min;
        int high = max;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(nums,mid,k)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int mid, int k) {
        int count = 0;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] <= mid) {
                count++;
                i+=2;
            } else {
                i+=1;
            }
        }
        return count >= k;
    }
}
