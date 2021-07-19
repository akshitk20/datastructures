package com.practice.leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class ThirdMax {
    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        if(list.size() < 3)
            return list.get(list.size()-1);
        else
            return list.get(list.size()-3);
    }
}
