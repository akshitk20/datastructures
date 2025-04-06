package com.practice.leetcode.daily.april25;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetsXOR1863_5 {
    // TC : (N * 2 ^N )
    // SC : (N * 2 ^ N)
    List<List<Integer>> subsets = new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        subsetXORSum(0, nums, new ArrayList<>());
        for (int i = 0 ; i < subsets.size() ; i++) {
            for (int j = 0 ; j < subsets.get(i).size() ; j++) {
                System.out.print(subsets.get(i).get(j) + " ");
            }
            System.out.println() ;
        }
        for (int i = 0 ; i < subsets.size() ; i++) {
            List<Integer> list = subsets.get(i);
            int xor = 0;
            for (int x : list) {
                xor = xor ^ x;
            }
            ans += xor;
        }
        return ans;
    }

    public void subsetXORSum(int index, int[] nums, List<Integer> list) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(list));
            return;
        }
        // with nums[index]
        list.add(nums[index]);
        subsetXORSum(index+1, nums, list);
        list.remove(list.size()-1);


        //without nums[index]
        subsetXORSum(index+1, nums, list);
    }
}
