package com.practice.leetcode.daily.april25;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest781_20 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : answers) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            int groupSize = key + 1;
            int ng = (int) Math.ceil(val * 1.0 / groupSize);
            ans += ng * (groupSize);
        }
        return ans;
    }
}

