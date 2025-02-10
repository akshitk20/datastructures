package com.practice.leetcode.daily.feb25;

import java.util.Stack;

public class ClearDigits3174_10 {
    // TC : O(N)
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (Character.isDigit(ch) && Character.isLetter(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}
