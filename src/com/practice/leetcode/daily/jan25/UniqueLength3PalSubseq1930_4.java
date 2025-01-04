package com.practice.leetcode.daily.jan25;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalSubseq1930_4 {

    // hashset + 2 pointer approach
    public int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (Character ch : s.toCharArray()) {
            set.add(ch);
        }
        for (Character ch : set) {
            int i = -1;
            int j = 0;
            for (int k = 0 ; k < s.length() ; k++) {
                if (s.charAt(k) == ch) {
                    if (i == -1){
                        i = k;
                    }
                    j = k;
                }
            }
            Set<Character> between = new HashSet<>();
            for(int k = i+1 ; k < j ; k++) {
                between.add(s.charAt(k));
            }
            ans += between.size();
        }
        return ans;
    }
}
