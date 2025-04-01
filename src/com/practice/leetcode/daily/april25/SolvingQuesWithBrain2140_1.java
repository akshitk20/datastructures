package com.practice.leetcode.daily.april25;

import java.util.Arrays;

public class SolvingQuesWithBrain2140_1 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return mostPoints(0, questions, dp);
    }

    public long mostPoints(int index, int[][] questions, long[] dp) {
        if (index >= questions.length) return 0;

        if (dp[index] != -1) return dp[index];

        long notPick =  0 + mostPoints(index+1, questions, dp);

        long pick = questions[index][0] + mostPoints(index+questions[index][1]+1, questions, dp);
        return dp[index] = Math.max(notPick, pick);
    }
}
