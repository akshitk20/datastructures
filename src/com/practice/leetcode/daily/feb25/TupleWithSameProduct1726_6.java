package com.practice.leetcode.daily.feb25;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct1726_6 {
    // TC: O(N2) SC: O(N)
    // each sum in hashmap will contribute to 8 pairs
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            for (int j = i+1 ; j < nums.length ; j++) {
                int product = nums[i] * nums[j];
                count += 8 * map.getOrDefault(product,0);
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        return count;
    }
}
