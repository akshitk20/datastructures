package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindDisappearedElement {
    public static void main(String[] args) {
        int nums[] = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] freq = new int[nums.length+1];
        for(int i = 0 ; i < nums.length ; i++)
            freq[nums[i]]++;

        for(int i = 1 ; i < freq.length ; i++){
            if(freq[i] == 0)
                list.add(i);
        }
        return list;
    }
}
