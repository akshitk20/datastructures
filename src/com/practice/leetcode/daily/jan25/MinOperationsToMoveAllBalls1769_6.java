package com.practice.leetcode.daily.jan25;

public class MinOperationsToMoveAllBalls1769_6 {

    // brute force
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for (int i = 0 ; i < boxes.length() ; i++) {
            int sum = 0;
            for (int j = 0 ; j < boxes.length() ; j++) {
                if (boxes.charAt(j) == '1'){
                    sum += Math.abs(i-j);
                }
            }
            ans[i] = sum;
        }
        return ans;
    }

    // 2 pass O(n)
    public int[] minOperations2Pass(String boxes) {
        int[] ans = new int[boxes.length()];
        int moves = 0;
        int balls = 0;
        for (int i = 0 ; i < boxes.length() ; i++) {
            ans[i] = moves+balls;
            moves = moves+balls;
            balls+=(boxes.charAt(i)-'0');
        }
        moves = 0;
        balls = 0;
        for (int i = boxes.length()-1; i >= 0 ; i--) {
            ans[i]+=moves+balls;
            moves = moves+balls;
            balls+=(boxes.charAt(i)-'0');
        }
        return ans;
    }
}
