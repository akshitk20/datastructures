package com.practice.leetcode.daily.aug2025;

import java.util.HashMap;

public class FruitsIntoBasket904_4 {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int n = fruits.length;
        int sum = 0;

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l])-1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            sum = Math.max(sum, r-l+1);
            r++;
        }
        return sum;
    }
}
