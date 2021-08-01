package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class LexicographicOrder {

    List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i = 1; i <= 9 ; i++)
            setLexicalOrder(n,i);
        return list;
    }

    public void setLexicalOrder(int n , int count){
        if(count > n)
            return;
        else{
            list.add(count);
            for(int i = 0; i <= 9 ; i++)
                setLexicalOrder(n,count*10+i);
        }
    }
}
