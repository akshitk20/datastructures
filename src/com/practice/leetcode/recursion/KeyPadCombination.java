package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {

    List<String> list = new ArrayList<>();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return list;
        setLetterCombination(digits,"");
        return list;
    }

    public void setLetterCombination(String ques,String ans){
        if(ques.length() == 0)
            list.add(ans);
        else{
            char ch = ques.charAt(0);
            String res = map[ch-'0'];
            for(int i = 0 ; i < res.length() ; i++){
                setLetterCombination(ques.substring(1),ans+res.charAt(i));
            }
        }
    }
}
