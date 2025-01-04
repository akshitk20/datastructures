package com.practice.leetcode.strings;

import java.util.HashSet;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew"; //pwwkew abcabcbb
        System.out.println(lengthOfLongestSubstring(s));
    }
    // sliding-window
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int i = 0;
        int j = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;


    }

    //brute force
    public int lengthOfLongestSubstringBF(String s) {
        if (s.isEmpty())
            return 0;
        System.out.println(s.length());
        int ans = 1;
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i+1 ; j < s.length() ; j++) {
                if (areDistinct(s, i, j))
                    ans = Math.max(ans, (j-i+1));
            }
        }
        return ans;
    }

    public boolean areDistinct(String s, int i, int j) {
        boolean[] visited = new boolean[26];
        for (int k = i ; k <= j ; k++) {
            if (visited[s.charAt(k) - 'a'])
                return false;
            visited[s.charAt(k) - 'a'] = true;
        }
        return true;
    }

}
