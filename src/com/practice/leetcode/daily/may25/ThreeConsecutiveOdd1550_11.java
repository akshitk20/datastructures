package com.practice.leetcode.daily.may25;

public class ThreeConsecutiveOdd1550_11 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] % 2 == 1) {
                count++;
            } else {
                count = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount >= 3;
    }
}
