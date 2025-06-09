package com.practice.leetcode.daily.june25;

import java.util.*;

public class RobotToPrintLexicoGraphicSmallest2434_6 {
    public String robotWithString(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(2)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst();

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        char minCharacter = 'a';
        for (char c : s.toCharArray()) {
            stack.push(c);
            cnt[c - 'a']--;
            while (minCharacter != 'z' && cnt[minCharacter - 'a'] == 0) {
                minCharacter++;
            }
            while (!stack.isEmpty() && stack.peek() <= minCharacter) {
                res.append(stack.pop());
            }
        }

        return res.toString();
    }
}
