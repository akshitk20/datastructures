package com.practice.leetcode.daily.april25;

import java.util.HashSet;
import java.util.Set;

public class MinOperationsArrayValues3375_9 {
    // TC : O(N) SC : O(N)
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x < k) return -1;
            else if (x > k) set.add(x);
        }
        return set.size();
    }
}
