package com.practice.leetcode.daily.mar25;

import java.util.HashMap;
import java.util.Map;

public class DivideArray2206_17 {
    // TC : O(N) SC: O(N)
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) return false;
        }
        return true;
    }
}
