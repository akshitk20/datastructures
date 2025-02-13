package com.practice.leetcode.daily.feb25;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumOperationsExceedThreshold3066_13 {
    // TC : O(NlogN) SC : O(N)
    public int minOperations(int[] nums, int k) {
        if (nums.length < 2) return -1;
        PriorityQueue<Long> pq = new PriorityQueue<Long>(
                Arrays.stream(nums)
                        .mapToObj(i -> Long.valueOf(i))
                        //.boxed()
                        .collect(Collectors.toList())
        );
        int count = 0;
        while (pq.peek() < k) {
            long first = pq.remove();
            long second = pq.remove();
            pq.add(Math.min(first,second) * 2 + Math.max(first,second));
            count++;
        }
        return count;
    }
}
