package com.practice.leetcode.daily.april25;

public class FindNoEvenDigit1295_30 {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            int count = 0;
            while (n > 0) {
                n = n / 10;
                count++;
            }
            if (count % 2 == 0) ans++;
        }
        return ans;
    }
}
