package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int j = i+1, k = nums.length-1;
            while(j < k){
                if(j != i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k != nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0)
                    result.add(Arrays.asList(nums[i],nums[j++],nums[k]));
                else if(sum < 0)
                    j++;
                else
                    k--;
            }

        }
        return result;
    }
}
