package com.practice.leetcode.daily.may25;

import java.util.HashMap;

public class LongestPallindromeConcatenatetwoLetters2131_25 {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        boolean centerUsed = false;
        int ans = 0;

        for (String word : words) {
            String reverse = reverse(word);

            if (!word.equals(reverse)) {
                if (map.get(word) > 0 && map.getOrDefault(reverse, 0) > 0) {
                    ans += 4;
                    map.put(word, map.get(word) - 1);
                    map.put(reverse, map.get(reverse) - 1);
                }
            } else {
                if (map.get(word) >= 2) {
                    ans += 4;
                    map.put(word, map.get(word) - 2);
                } else if (map.get(word) == 1 && !centerUsed) {
                    ans += 2;
                    map.put(word, map.get(word) - 1);
                    centerUsed = true;
                }
            }
        }
        return ans;
    }

    public String reverse(String str) {
        char ch[] = str.toCharArray();
        int i = 0, j = ch.length-1;
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
        return new String(ch);
    }
}
