package com.practice.leetcode.daily.feb25;

import java.util.PriorityQueue;

public class MaxSumPairEqualDigits2342_12 {
    public int maximumSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        PriorityQueue<Integer>[] pq = new PriorityQueue[82];
        for (int i = 0 ; i < 82 ; i++) {
            pq[i] = new PriorityQueue<Integer>();
        }
        for (int n : nums) {
            int sum = getSum(n);
            pq[sum].add(n);
            if (pq[sum].size() > 2) {
                pq[sum].poll();
            }
        }
        for (PriorityQueue<Integer> queue : pq) {
            if (queue.size() == 2) {
                int first = queue.poll();
                int second = queue.poll();
                ans = Math.max(ans, first+second);
            }
        }
        if (ans == Integer.MIN_VALUE) return -1;
        return ans;
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
