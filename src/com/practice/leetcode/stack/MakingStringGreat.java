package com.practice.leetcode.stack;

import java.util.Stack;

public class MakingStringGreat {

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(ch-stack.peek())== 32){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
