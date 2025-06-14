package com.practice.leetcode.daily.june25;

public class MaxDifferenceRemappingDigit2566_14 {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        String temp = s;
        int pos = 0;
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }

        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }

        temp = temp.replace(temp.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(temp);
    }
}
