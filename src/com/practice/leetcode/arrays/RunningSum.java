package com.practice.leetcode.arrays;

import java.util.Arrays;

public class RunningSum {

    public static void main(String[] args) {
        int[] nums = new int[4];
        for(int i = 0 ; i < 4 ; i++){
            nums[i] = i+1;
        }
        System.out.println(Arrays.toString(nums));
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] runningSum(int[] nums) {
        int len = nums.length;
        int[] result = new int[nums.length];
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j <= i ; j++){
                result[i] += nums[j];
            }
        }
        return result;
    }
}
