package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {0};
        List<Integer> list = new ArrayList<>();
        setSubsets(nums,list);
        System.out.println(result);
    }

    private static void setSubsets(int[] nums, List<Integer> list) {
        if(nums.length == 0)
            result.add(new ArrayList<>(list));
        else{
            list.add(nums[0]);
            setSubsets(Arrays.copyOfRange(nums,1,nums.length),list);
            list.remove(list.size()-1);

            setSubsets(Arrays.copyOfRange(nums,1,nums.length), list);
        }
    }
}
