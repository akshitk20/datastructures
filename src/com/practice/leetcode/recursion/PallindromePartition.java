package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartition {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        setPartitions(s,"",list);
        return result;
    }

    public void setPartitions(String ques,String ans, List<String> list){
        if(ques.isEmpty()){
            result.add(new ArrayList<>(list));
        }else{
            for(int i = 1 ; i <= ques.length() ; i++){
                if(isPallindrome(ques.substring(0,i))){
                    list.add(ques.substring(0,i));
                    setPartitions(ques.substring(i),ans+ques.substring(0,i),list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public boolean isPallindrome(String input){
        int i = 0 , j = input.length()-1;
        while(i < j){
            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
