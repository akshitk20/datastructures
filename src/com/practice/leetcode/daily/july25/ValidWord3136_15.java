package com.practice.leetcode.daily.july25;

import java.util.Arrays;
import java.util.List;

public class ValidWord3136_15 {

    public boolean isValid(String word) {
        List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        if (word.length() < 3) return false;
        int vowelCount = 0;
        int consonentCount = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                if (list.contains(ch)) {
                    vowelCount++;
                } else if (Character.isLetter(ch)) {
                    consonentCount++;
                }
            } else {
                return false;
            }
        }
        return vowelCount != 0 && consonentCount != 0;

    }
}
