package com.practice.leetcode.daily.june25;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SubseqOfLengthK2099_28 {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0 ; i < nums.length ; i++) {
            pq.offer(new int[] {nums[i], i});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        Set<Integer> set = new HashSet<>(); // storing index
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            set.add(curr[1]);
        }
        int x = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (set.contains(i)) {
                result[x] = nums[i];
                x++;
            }
        }
        return result;
    }
}
