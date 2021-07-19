package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoveNegativeToBeginning {
    public static void main(String[] args) {
        int[] nums = new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6};
        rearrange(nums);
    }

    public static void rearrange(int[] nums){
//        List<Integer> negative = new ArrayList<>();
//        List<Integer> positive = new ArrayList<>();
//
//        for(int i = 0 ; i < nums.length ; i++){
//            if(nums[i] < 0){
//                negative.add(nums[i]);
//            }else{
//                positive.add(nums[i]);
//            }
//        }
//
//        for(int i = 0 ; i < negative.size() ; i++){
//            nums[i] = negative.get(i);
//        }
//        int k = negative.size();
//        for(int i = negative.size() ; i < nums.length ; i++){
//            nums[i] = positive.get(i-k);
//        }

        //2 pointer approach
        int left = 0 , right = nums.length-1;
        while(left <= right){
            if(nums[left] < 0 && nums[right] < 0)
                left++;
            else if(nums[left] > 0 && nums[right] < 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            else if(nums[left] > 0 && nums[right] > 0)
                right--;
            else{
                left++;
                right--;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
