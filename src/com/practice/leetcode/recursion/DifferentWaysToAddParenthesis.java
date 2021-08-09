package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String expression) {
        if(expression.indexOf('+') == -1 && expression.indexOf('-') == -1 && expression.indexOf('*') == -1){
            List<Integer> list = new ArrayList<>();
            list.add(Integer.parseInt(expression));
            return list;
        }else{
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < expression.length() ; i++){
                if(expression.charAt(i) == '+' || expression.charAt(i) == '-' ||                                    expression.charAt(i) == '*'){
                    List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i+1));

                    for(Integer it : left){
                        for(Integer j : right){
                            list.add(getResult(it,j,expression.charAt(i)));
                        }
                    }
                }
            }
            return list;
        }
    }

    public int getResult(int i , int j , char ch){
        if(ch == '+')
            return i+j;
        else if(ch == '-')
            return i-j;
        else
            return i * j;
    }
}
