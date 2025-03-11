package com.practice.leetcode.daily.mar25;

public class NumberOfSubstrings3Chars1358_11 {
    // TC : O(N) sliding window
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        int[] freq = {-1, -1, -1};
        for (int i = 0 ; i < n ; i++) {
            freq[s.charAt(i)-'a'] = i;
            if (freq[0] != -1 && freq[1] != -1 && freq[2] != -1) {
                ans += 1 + Math.min(freq[0],Math.min(freq[1],freq[2]));
            }
        }

        return ans;
    }
}
