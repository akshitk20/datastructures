package com.practice.leetcode.daily.feb25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLexicographic1415_19 {
    // O(2^n * N)
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        generateHappy(n, list,  new StringBuilder());
        System.out.println(list.size());
        if (list.size() < k)
            return "";

        Collections.sort(list);
        return list.get(k-1);
    }

    public void generateHappy(int n, List<String> list, StringBuilder ans) {
        if (ans.length() == n) {
            list.add(ans.toString());
            return;
        }
        for (char ch = 'a' ; ch <= 'c' ; ch++) {
            if (!ans.isEmpty() && ans.charAt(ans.length()-1) == ch)
                continue;
            ans.append(ch);
            generateHappy(n,list,ans);
            ans.deleteCharAt(ans.length()-1);
        }
    }
}
