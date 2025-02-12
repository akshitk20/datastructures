package com.practice.leetcode.daily.feb25;

import java.util.PriorityQueue;

public class MaxSumPairEqualDigits2342_12 {
    /*
    * Time Complexity: O(nlogm)
    The time complexity of this approach is primarily determined by the operations performed
    on the input array nums and the computation of digit sums. The calculateDigitSum function
    computes the sum of digits for a given number, which takes O(logm) time.
    This is because the number of digits in a number is proportional to log m.
    The first loop iterates over all n elements in nums and computes their digit sums, resulting in a total time of O(nlogm).
    The second loop also iterates over all n elements in nums. For each element, it performs a push operation on a priority queue (min-heap).
    Since the heap size is limited to 2, each push operation takes O(1) time. Thus, this loop contributes O(n) to the time complexity.
    Finally, the third loop iterates over the digitSumGroups array, which has a size proportional to the maximum digit sum, O(logm).
    For each heap of size 2, it performs two pop operations and a sum computation, each taking O(1) time. This loop adds O(logm) to the time complexity.
    Combining all these, the overall time complexity is O(nlogm).
    *
    * */
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
