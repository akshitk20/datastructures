package com.practice.leetcode.arrays;

import java.util.*;

public class MajorityElement2 {
    public static void main(String[] args) {
        int nums[] = {1,2};
        System.out.println(majorityElement(nums));
    }

    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int x = nums.length/3;
        Map<Integer,Integer> map = new HashMap<>();
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
                list.add((Integer) elem.getKey());
            }
        }

        return list;
    }
}
