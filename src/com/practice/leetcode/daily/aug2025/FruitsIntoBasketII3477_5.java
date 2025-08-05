package com.practice.leetcode.daily.aug2025;

import java.util.HashSet;
import java.util.Set;

public class FruitsIntoBasketII3477_5 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        int n = fruits.length;

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (fruits[i] <= baskets[j] && !visited.contains(j)) {
                    count++;
                    visited.add(j);
                    break;
                }
            }
        }
        return n-count;

    }
}
