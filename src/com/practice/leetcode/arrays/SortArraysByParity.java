package com.practice.leetcode.arrays;

public class SortArraysByParity {
    public int[] sortArrayByParity(int[] nums) {
        int k = 0;
        int arr[] = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            arr[i] = nums[i];
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 == 0){
                arr[k] = nums[i];
                k++;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] % 2 != 0){
                arr[k] = nums[i];
                k++;
            }
        }
        return arr;
    }
}
