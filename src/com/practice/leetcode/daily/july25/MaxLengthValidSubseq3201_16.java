package com.practice.leetcode.daily.july25;

public class MaxLengthValidSubseq3201_16 {
    public int maximumLength(int[] nums) {
        int even = 0;
        int odd = 0;

        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int parity = nums[0] % 2;
        int alternating = 1;

        for (int i = 1 ; i < nums.length ; i++) {
            int currParity = nums[i] % 2;
            if (currParity != parity) {
                alternating++;
                parity = currParity;
            }
        }
        return Math.max(even, Math.max(odd, alternating));
    }
}
