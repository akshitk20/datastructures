package com.practice.leetcode.daily.feb25;

public class SpecialArray3151_1 {
    // check if the mod count is same or not
    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) return true;
        int count = 0;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i-1] % 2 == nums[i] % 2)
                count++;
            else
                continue;
        }
        if (count == 0) return true;
        else
            return false;
    }
}
