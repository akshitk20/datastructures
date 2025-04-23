package com.practice.leetcode.daily.april25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLargestGroup1399_23 {

    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1 ; i <= n ; i++) {
            int sum = getSum(i);
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }

        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key).size());
        }

        for (int key : map.keySet()) {
            if (map.get(key).size() == max) {
                count++;
            }
        }

        return count;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
