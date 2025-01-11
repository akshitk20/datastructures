package com.practice.leetcode.arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        reverse(nums, 0 , n - 1);
        reverse(nums, 0 , k - 1);
        reverse(nums, k , n - 1);
    }

    public static void reverse(int[] nums, int i , int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotate(nums, 3);
    }
}
