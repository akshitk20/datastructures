package com.practice.leetcode.daily.jan25;

public class MaxScoreSplit1422_1 {

    // brute force
    public static int maxScore(String s) {
        int max = Integer.MIN_VALUE;
        int n = s.length();
        for (int i = 0 ; i < s.length() - 1 ; i++) {
            int count = 0;
            for (int j = 0 ; j <= i ; j++) {
                if (s.charAt(j) == '0')
                    count++;
            }
            for (int j = i+1 ; j < s.length() ; j++) {
                if (s.charAt(j) == '1')
                    count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // o(n)
    public static int maxScoreOn(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        int ans = 0;
        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }

            ans = Math.max(ans, zeros + ones);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = new String("011101");
        System.out.println(maxScoreOn(s));
    }
}
