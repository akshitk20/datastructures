package com.practice.leetcode.daily.mar25;

import java.util.LinkedList;
import java.util.Queue;

public class PartitionArrayPivot2161_3 {

    // TC : O(N) SC : O(N)
    public int[] pivotArrayON(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        Queue<Integer> minQueue = new LinkedList<>();
        Queue<Integer> maxQueue = new LinkedList<>();
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] < pivot) {
                minQueue.offer(nums[i]);
            } else if (nums[i] > pivot) {
                maxQueue.offer(nums[i]);
            } else {
                count++;
            }
        }

        int k = 0;
        while (!minQueue.isEmpty()) {
            result[k++] = minQueue.poll();
        }

        for (int i = k ; i < k+count ; i++) {
            result[i] = pivot;
        }
        k += count;
        while (!maxQueue.isEmpty()) {
            result[k++] = maxQueue.poll();
        }

        return result;
    }

    // TC : O(N) SC: O(1)
    public int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int less = 0;
        int equal = 0;
        for (int n : nums) {
            if (n < pivot) less++;
            else if (n == pivot) equal++;
        }

        int lessI = 0;
        int equalI = less;
        int greaterI = less+equal;

        for (int n : nums) {
            if (n < pivot) {
                result[lessI++] = n;
            } else if (n > pivot) {
                result[greaterI++] = n;
            } else {
                result[equalI++] = n;
            }
        }
        return result;
    }

}
