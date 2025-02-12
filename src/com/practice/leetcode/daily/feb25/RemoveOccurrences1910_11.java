package com.practice.leetcode.daily.feb25;

import java.util.Stack;

public class RemoveOccurrences1910_11 {
    // TC : O(N) SC: O(N)
    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= part.length() && checkMatch(stack, part, part.length())) {
                for (int j = 0 ; j < part.length() ; j++) {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public boolean checkMatch(Stack<Character> stack, String part, int len) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);

        for (int i = len-1; i >= 0 ; i--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();
        }
        return true;
    }
}
