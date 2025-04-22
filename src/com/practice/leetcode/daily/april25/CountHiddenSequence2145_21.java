package com.practice.leetcode.daily.april25;

import java.util.Collections;

public class CountHiddenSequence2145_21 {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, sum = 0;
        for (int n : differences) {
            sum += n;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        return (int) Math.max(0, (upper-max) - (lower-min) + 1);
    }
}
