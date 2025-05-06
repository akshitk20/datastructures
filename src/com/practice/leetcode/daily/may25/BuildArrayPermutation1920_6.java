package com.practice.leetcode.daily.may25;

public class BuildArrayPermutation1920_6 {
    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
