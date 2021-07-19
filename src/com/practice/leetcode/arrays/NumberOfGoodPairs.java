package com.practice.leetcode.arrays;

import java.util.HashMap;

public class NumberOfGoodPairs {
    public static void main(String[] args) {

    }

    public int numIdenticalPairs(int[] nums){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int counter = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            int temp = nums[i];
            if (hashMap.get(temp) == null)
                hashMap.put(temp, 0);
            else {
                int duplicate = hashMap.get(temp);
                hashMap.put(temp, hashMap.get(temp) + 1);
                counter += duplicate;
            }
        }
        return counter;
    }

}
