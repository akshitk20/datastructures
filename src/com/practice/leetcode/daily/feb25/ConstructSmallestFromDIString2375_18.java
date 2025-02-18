package com.practice.leetcode.daily.feb25;

import java.util.HashSet;
import java.util.Set;

public class ConstructSmallestFromDIString2375_18 {
    // TC O(N! * 9)
    public String smallestNumber(String pattern) {
        Set<Character> used = new HashSet<>();
        StringBuilder result = new StringBuilder();
        smallestNumber(pattern , result, used, 0);
        return result.toString();
    }

    public boolean smallestNumber(String pattern, StringBuilder result, Set<Character> used, int index ) {
        // base case
        if (index == pattern.length()+1) {
            return true;
        }

        for (char digit = '1' ; digit <= '9' ; digit++) {
            if (used.contains(digit)) continue;

            if (!result.isEmpty() && ((pattern.charAt(index-1) == 'I' && result.charAt(result.length()-1) >= digit)
                    || (pattern.charAt(index-1) == 'D' && result.charAt(result.length()-1) <= digit)))
                continue;

            result.append(digit);
            used.add(digit);
            if (smallestNumber(pattern, result, used, index+1)) return true;
            result.deleteCharAt(result.length()-1);
            used.remove(digit);
        }
        return false;
    }
}
