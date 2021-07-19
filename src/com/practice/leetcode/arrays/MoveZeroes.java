package com.practice.leetcode.arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int arr[] = new int[]{0,1,0,3,12};
        moveZeroes(arr);
    }
    public static void moveZeroes(int[] nums) {
        // int k = nums.length-1;
        // Arrays.sort(nums);
        int arr[] = new int[nums.length];
        if(nums.length <= 1)
            return;
        int x = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != 0){
                nums[x] = nums[i];
                x++;
            }
        }
        for(int i = x ; i < nums.length ; i++){
            nums[i] = 0;
        }

//        for(int i = 0 ; i < nums.length ; i++)
//            nums[i] = arr[i];

        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(nums[i]+" ");
        // for(int i = 0 ; i < nums.length ; i++){
        //     if(nums[i] == 0){
        //         int temp = nums[i];
        //         nums[i] = nums[k];
        //         nums[k] = temp;
        //     }
        //     k--;
        // }
    }
}
