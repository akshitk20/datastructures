package com.practice.leetcode.daily.mar25;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexValidSplit2780_27 {
    // TC : O(N) SC: O(N)
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int n = nums.size();

        for (int x : nums) {
            secondMap.put(x, secondMap.getOrDefault(x, 0) + 1);
        }

        for (int i = 0 ; i < n ; i++) {
            int num = nums.get(i);

            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);
            secondMap.put(num, secondMap.getOrDefault(num, 0) - 1);


            if (2 * firstMap.get(num) > i+1 && 2 * secondMap.get(num) > n-i-1) {
                return i;
            }
        }
        return -1;
    }
}
