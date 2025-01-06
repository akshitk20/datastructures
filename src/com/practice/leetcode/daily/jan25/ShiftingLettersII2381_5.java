package com.practice.leetcode.daily.jan25;

public class ShiftingLettersII2381_5 {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix = new int[s.length() + 1];
        for (int i = 0 ; i < shifts.length ; i++) {
            int left = shifts[i][0];
            int right = shifts[i][1];
            int dir = shifts[i][2];
            prefix[right + 1] += (dir == 1) ? 1 : -1;
            prefix[left] += (dir == 1) ? -1 : 1;
        }
        int diff = 0;
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) - 'a';
        }

        for (int i = prefix.length - 1; i > 0; i--) {
            diff += prefix[i];
            res[i - 1] = (diff + res[i - 1] + 26) % 26;
        }

        StringBuilder result = new StringBuilder();
        for (int n : res) {
            result.append((char) ('a' + n));
        }

        return result.toString();
    }


}
