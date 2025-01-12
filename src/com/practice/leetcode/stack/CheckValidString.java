package com.practice.leetcode.stack;

import java.util.Stack;

public class CheckValidString {
    // O(n)
    // use two stack
    // push ( in one stack and * in another
    // if ) then pop for stack1 first as * does not matter
    // if stack1 is empty then pop from stack2
    // check if something is remaining in either stack1 or stack2
    public boolean checkValidString(String s) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '(') {
                stack1.push(i);
            } else if (s.charAt(i) == '*') {
                stack2.push(i);
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                } else if (!stack2.isEmpty()) {
                    stack2.pop();
                } else {
                    return false;
                }
            }
        }

        while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() < stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }
        if (!stack1.isEmpty()) {
            return false;
        }
        return true;
    }
}
