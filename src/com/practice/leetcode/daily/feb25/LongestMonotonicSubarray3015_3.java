package com.practice.leetcode.daily.feb25;

public class LongestMonotonicSubarray3015_3 {
    // brute force
    // O(n^2)
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int count = 1;
            for (int j = i+1 ; j < nums.length ; j++) {
                if (nums[j-1] < nums[j]) { // inc sequence
                    count++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(count, maxLength);
        }
        for (int i = 0 ; i < nums.length ; i++) {
            int count = 1;
            for (int j = i+1 ; j < nums.length ; j++) {
                if (nums[j-1] > nums[j]) { // dec sequence
                    count++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }

    // O(N) single pass
    public int longestMonotonicSubarraySinglePass(int[] nums) {
        int maxLength = 1;
        int incLength = 1;
        int decLength = 1;

        for (int i = 0 ; i < nums.length-1 ; i++) {
            if (nums[i] < nums[i+1]) { // increasing flow
                incLength++;
                decLength = 1;
            } else if (nums[i] > nums[i+1]) { // decreasing flow
                decLength++;
                incLength = 1;
            } else {
                incLength = 1; // equal flow
                decLength = 1;
            }
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }
        return maxLength;
    }
}

