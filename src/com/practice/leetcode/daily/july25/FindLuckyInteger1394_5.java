package com.practice.leetcode.daily.july25;

import java.util.HashMap;

public class FindLuckyInteger1394_5 {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int ans = -1;

        for (int key : map.keySet()) {
            int val = map.get(key);
            if (key == val) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }
}
