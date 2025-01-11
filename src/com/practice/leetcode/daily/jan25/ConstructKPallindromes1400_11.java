package com.practice.leetcode.daily.jan25;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPallindromes1400_11 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int odd = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                odd++;
            }
        }
        return odd <= k;
    }
}
