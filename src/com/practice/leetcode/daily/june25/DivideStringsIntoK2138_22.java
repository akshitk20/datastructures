package com.practice.leetcode.daily.june25;

import java.util.ArrayList;
import java.util.List;

public class DivideStringsIntoK2138_22 {
    public String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        int i = 0;

        while (i < n) {
            int j = Math.min(i+k, n);

            String temp = s.substring(i, j);

            if (temp.length() < k) {
                int remaining = k - temp.length();
                while(remaining-- > 0) {
                    temp += fill;
                }
            }
            result.add(temp);
            i+=k;
        }

        String[] ans = new String[result.size()];
        for (i = 0 ; i < result.size() ; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
