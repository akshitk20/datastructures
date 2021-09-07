package com.practice.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKRepeatChars {
    public static void main(String[] args) {
        String s = "ababbc";
        System.out.println(longestSubstring(s,3));
    }

    private static int longestSubstring(String s, int n) {
        int ans = 0;
        int count = 0;
        int maxCount = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j <= s.length() ; j++){
                map.put(s.substring(i,j),s.substring(i,j).length());
            }
        }
        for(Map.Entry elem : map.entrySet()){
            String str = (String) elem.getKey();
            int[] freq = getFrequency(str);

            for(int i = 0 ; i < freq.length ; i++){
                if(freq[i] >= n){
                    count++;
                }
            }
            if(count == str.length())
              count = str.length();
            if(maxCount < count)
                maxCount = count;
        }
        return maxCount;
    }

    private static int[] getFrequency(String str) {
        int[] freq = new int[26];
        for(int i = 0 ; i < str.length() ; i++){
            freq[str.charAt(i)-'a']++;
        }
        return freq;
    }
}
