package com.practice.leetcode.daily.june25;

import java.util.*;

public class FindAllKDistantIndices2200_24 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (Math.abs(i-j) <= k && nums[j] == key) {
                    result.add(i);
                    break;
                }
            }
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.firstKey();
        Collections.sort(result);
        return result;

    }
}
