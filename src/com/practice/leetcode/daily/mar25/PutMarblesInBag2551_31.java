package com.practice.leetcode.daily.mar25;

import java.util.Arrays;

public class PutMarblesInBag2551_31 {
    // TC : O(nlogn) SC : O(N)
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pair = new int[n-1];
        for(int i = 1 ; i < n ; i++){
            pair[i-1] = weights[i-1]+weights[i];
        }
        Arrays.sort(pair);
        long max = 0;
        long min = 0;
        for(int i = 0 ; i < k-1 ; i++){
            min+=pair[i];
            max+=pair[n-2-i]; // pair has size n-1 so last elem will be n-2
        }
        return max-min;
    }
}
