package com.practice.leetcode.daily.jan25;

import java.util.HashMap;
import java.util.Map;

public class MinLengthOfString3223_13 {
    // O(n) : maintain the frequency of each character. if frequency >= 3 subtract 2 to get count.
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        for (Integer values : map.values()) {
            while (values >= 3) {
                values = values-2;
            }
            count += values;
        }
        return count;
    }
}
