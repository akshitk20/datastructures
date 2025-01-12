package com.practice.leetcode.daily.jan25;

import java.util.Stack;

public class CheckIfParenthesisValid2116_12 {
    // O(n) time and space
    public boolean canBeValid(String s, String locked) {
        Stack<Integer> lock = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        // push 0 in unlocked stack
        // push ( in lock stack
        // pop first from lock stack to utilize it
        for (int i = 0 ; i < s.length() ; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                lock.push(i);
            } else {
                if (!lock.isEmpty()) {
                    lock.pop();
                } else if (!unlocked.isEmpty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }
        // match remaining brackets
        while (!lock.isEmpty() && !unlocked.isEmpty() && lock.peek() < unlocked.peek()) {
            lock.pop();
            unlocked.pop();
        }
        if (!lock.isEmpty()) {
            return false;
        }
        return unlocked.size() % 2 == 0;
    }
}
