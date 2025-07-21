package com.practice.leetcode.daily.july25;

public class MakeStringFancy1957_21 {
    public String makeFancyString(String s) {
        int n = s.length();
        int count = 1;
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        for (int i = 1 ; i < n ; i++) {
            if (s.charAt(i) == result.charAt(result.length()-1)) {
                count++;
                if (count < 3) {
                    result.append(s.charAt(i));
                }
            } else {
                result.append(s.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }
}
