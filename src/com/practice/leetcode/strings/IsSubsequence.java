package com.practice.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        ArrayList<String> subsequences = getSubsequences(t);
        if(subsequences.contains(s))
            return true;
        else
            return false;
    }

    public ArrayList<String> getSubsequences(String input){
        if(input.isEmpty())
            return new ArrayList<>(Arrays.asList(""));
        else{
            char ch = input.charAt(0);
            ArrayList<String> rr = getSubsequences(input.substring(1));
            ArrayList<String> nr = new ArrayList<>();
            for(String elem: rr){
                nr.add(elem);
                nr.add(ch+elem);
            }
            return nr;
        }
    }
}
