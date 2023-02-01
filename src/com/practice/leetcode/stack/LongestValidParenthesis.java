package com.practice.leetcode.stack;

import java.util.Stack;

public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        if(s.length() < 2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }

        int endIndex = n;
        int max = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            int startIndex = stack.pop();
            max = Math.max(max,endIndex-startIndex-1);
            endIndex = startIndex;
        }

        return Math.max(endIndex,max);
    }
}
