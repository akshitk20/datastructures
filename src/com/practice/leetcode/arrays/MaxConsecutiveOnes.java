package com.practice.leetcode.arrays;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int nums[]){
        int count = 0 , maxCount = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0)
                count = 0;
            else
                count++;
            if(maxCount < count)
                maxCount = count;
        }
        return maxCount;
    }
}
