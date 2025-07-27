package com.practice.leetcode.daily.july25;

import java.util.ArrayList;
import java.util.List;

public class CountHillValley2210_27 {
    public int countHillValley(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0 ; i < n - 1 ; i++) {
            if (nums[i] == nums[i+1]) {
                continue;
            } else {
                list.add(nums[i]);
            }
        }
        list.add(nums[nums.length-1]);
        int count = 0;
        for (int i = 1 ; i < list.size() - 1 ; i++) {
            if (list.get(i) > list.get(i-1) && list.get(i) > list.get(i+1)) {
                count++;
            } else if (list.get(i) < list.get(i-1) && list.get(i) < list.get(i+1)) {
                count++;
            }
        }
        return count;
    }
}
