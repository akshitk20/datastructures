package com.practice.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElements {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int x = nums.length/2;
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int count  = 1;
        for(int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(nums[i]))
                count++;
            else
                count = 1;
            map.put(nums[i],count);
        }
        for(Map.Entry elem : map.entrySet()){
            if((int)elem.getValue() > x){
                ans = (int) elem.getKey();
            }
        }

        return ans;
    }
}
