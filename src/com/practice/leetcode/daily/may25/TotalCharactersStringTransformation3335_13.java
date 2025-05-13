package com.practice.leetcode.daily.may25;

public class TotalCharactersStringTransformation3335_13 {

    // Brute force
    public int lengthAfterTransformations(String s, int t) {
        while (t-- > 0) {
            StringBuilder result = new StringBuilder();
            for (int i = 0 ; i < s.length() ; i++) {
                if (s.charAt(i) == 'z') {
                    result.append("a").append("b");
                } else {
                    result.append((char)(s.charAt(i) + 1));
                }
            }
            s = result.toString();
        }
        System.out.println(s);
        return s.length();
    }

    private static final int MOD = 1000000007;

    public int lengthAfterTransformationOptimised(String s, int t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a'];
        }
        for (int round = 0; round < t; ++round) {
            int[] nxt = new int[26];
            nxt[0] = cnt[25];
            nxt[1] = (cnt[25] + cnt[0]) % MOD;
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1];
            }
            cnt = nxt;
        }
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;
    }

}
