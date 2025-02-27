package com.practice.leetcode.daily.feb25;

import java.util.HashSet;
import java.util.Set;

public class LenOfLongestFibSeq {
    // TC : O(N^2 log M) Brute force
    // todo: optimize with DP
    public int lenLongestFibSubseq(int[] arr) {
        int maxLength = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }
        for (int i = 0 ; i < arr.length ; i++) {
            for (int j = i+1 ; j < arr.length ; j++) {
                int prev = arr[j];
                int curr = arr[i]+arr[j];
                int len = 2;

                while (set.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    len++;
                    maxLength = Math.max(maxLength, len);
                }

            }
        }
        return maxLength;
    }
}
