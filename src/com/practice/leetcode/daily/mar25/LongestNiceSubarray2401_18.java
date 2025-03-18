package com.practice.leetcode.daily.mar25;

public class LongestNiceSubarray2401_18 {
    // TC : O(N) SC: O(1)
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int curr = 0;
        while (right < n) {
            while ((nums[right] & curr) != 0) {
                int ele = nums[left];
                curr = curr ^ ele; // reset bit
                left++;
            }
            curr = curr | nums[right]; // set bit
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;

    }
}
