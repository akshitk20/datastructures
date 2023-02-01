package com.practice.leetcode.stack;

import java.util.*;

public class FreqStack {
    Map<Integer,Integer> map = new HashMap<>();
    List<Stack<Integer>> list = new ArrayList<>();
    public FreqStack() {

    }

    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        int freq = map.get(val);
        if(freq-1 >= list.size()){
            list.add(new Stack<>());
        }
        list.get(freq-1).add(val);

    }

    public int pop() {
        int size = list.size();
        int x = list.get(size-1).pop();
        if(list.get(size-1).isEmpty()){
            list.remove(size-1);
        }
        map.put(x,map.get(x)-1);
        if(map.get(x) == 0){
            map.remove(x);
        }
        return x;
    }
}
