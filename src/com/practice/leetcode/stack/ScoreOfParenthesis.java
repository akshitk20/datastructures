package com.practice.leetcode.stack;

import java.util.Stack;

public class ScoreOfParenthesis {
    public static void main(String[] args) {
        String str = "()(())";
        int ans = scoreOfParenthesis(str);
        System.out.println(ans);
    }

    private static int scoreOfParenthesis(String str) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(-1);
            }else{
                if(stack.peek() == -1){
                    stack.pop();
                    stack.push(1);
                }else {
                    int val = 0;
                    while (stack.peek() != -1){
                        val+=stack.pop();
                    }
                    stack.pop();
                    stack.push(2*val);
                }
            }
        }
        int ans = 0;
        while(!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }
}
