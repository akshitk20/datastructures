package com.practice.leetcode.daily.june25;

import java.util.HashMap;

public class LongestHarmoniousSubseq594_30 {
    public int findLHS(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int num : nums) {
            int min = num;
            int max = num + 1;

            if (map.containsKey(max)) {
                result = Math.max(result, map.get(min) + map.get(max));
            }
        }
        return result;
    }
}
