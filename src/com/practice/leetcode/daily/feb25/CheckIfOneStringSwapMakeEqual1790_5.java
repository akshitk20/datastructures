package com.practice.leetcode.daily.feb25;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIfOneStringSwapMakeEqual1790_5 {
    // TC: O(N^2) SC: O(N)
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        Set<String> set = new HashSet<>();
        for (int i = 0 ; i < s2.length() ; i++) {
            for (int j = i + 1 ; j < s2.length() ; j++) {
                String swap = swap(s2, i , j);
                set.add(swap);
            }
        }
        if (set.contains(s1)) return true;
        return false;
    }

    public String swap(String s2, int i , int j) {
        char[] ch = s2.toCharArray();
        char temp = ch[j];
        ch[j] = ch[i];
        ch[i] = temp;
        return new String(ch);
    }

    // TC: O(N) SC: O(26)
    public boolean areAlmostEqualON(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int diff = 0;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0 ; i < s1.length() ; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 2) return false; //not possible because more than two diff cannot be done with one swap
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(freq1, freq2);
    }
}
