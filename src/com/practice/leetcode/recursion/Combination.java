package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        setCombination(n,0,k,list,0);
        return result;
    }

    public void setCombination(int n, int x, int k , List<Integer> list, int pos){
        if(x == k)
            result.add(new ArrayList<>(list));
        else if(n == pos)
            return;
        else{
            list.add(pos+1);
            setCombination(n,x+1,k,list,pos+1);
            list.remove(list.size()-1);

            setCombination(n,x,k,list,pos+1);
        }
    }
}
