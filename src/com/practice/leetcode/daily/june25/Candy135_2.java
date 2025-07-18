package com.practice.leetcode.daily.june25;

public class Candy135_2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n-1] = 1;

        for (int i = 1 ; i < n ; i++) {
            if (ratings[i] > ratings[i-1]) {
                left[i] = 1 + left[i-1];
            } else {
                left[i] = 1;
            }
        }

        for (int i = n-2 ; i >= 0 ; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = 1 + right[i+1];
            } else {
                right[i] = 1;
            }
        }

        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}
