package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        setParenthesis(n , 0 , 0, "");
        return list;
    }

    public void setParenthesis(int n , int open , int close, String ans){
        if(n == open && n == close)
            list.add(ans);
        else{
            if(n > open)
                setParenthesis(n,open+1,close,ans+"(");
            if(open > close)
                setParenthesis(n,open,close+1,ans+")");
        }
    }
}
