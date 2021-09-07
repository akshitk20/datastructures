package com.practice.leetcode.arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            sum+=nums[i];
            if(maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }
}
