package com.practice.leetcode.arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[k] != nums[i]){
                k++;
                nums[k] = nums[i];
            }
        }

        for(int x = 0 ; x < nums.length ; x++){
            System.out.print(nums[x] +" ");
        }
        return k+1;
    }
}
