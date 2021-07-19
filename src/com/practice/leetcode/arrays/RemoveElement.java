package com.practice.leetcode.arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        int l = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }else
                l--;
        }
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i] +" ");
        }
        return l;
    }
}
