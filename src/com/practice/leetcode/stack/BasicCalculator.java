package com.practice.leetcode.stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char prevSign = '+';
        int no = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                no = (no*10)+(ch-'0');
            }
            if(isOperator(ch) || i == s.length()-1){
                if(prevSign == '+'){
                    stack.push(no);
                }else if(prevSign == '-'){
                    stack.push(-no);
                }else if(prevSign == '*'){
                    int top = stack.pop();
                    stack.push(top*no);
                }else if(prevSign == '/'){
                    int top = stack.pop();
                    stack.push(top/no);
                }
                no=0;
                prevSign=ch;
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    boolean isOperator(char ch){
        return ch=='+' || ch == '-' || ch == '*' || ch == '/';
    }
}
