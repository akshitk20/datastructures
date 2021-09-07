package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    public static List<String> letterCasePermutation(String s){
        List<String> strings = new ArrayList<>();
        popluateList(s,"",strings);
        return strings;
    }

    private static void popluateList(String ques, String ans, List<String> list) {
        if(ques.isEmpty()){
            list.add(ans);
        }else{
            char ch = ques.charAt(0);
            if((ch >= 'a' && ch <= 'z'))
                popluateList(ques.substring(1),ans+(char)(ch-32),list);
            else if((ch >= 'A' && ch <= 'Z'))
                popluateList(ques.substring(1),ans+(char)(ch+32),list);
            popluateList(ques.substring(1),ans+ch,list);
        }
    }

}
