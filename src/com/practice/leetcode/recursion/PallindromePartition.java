package com.practice.leetcode.recursion;

public class PallindromePartition {


    public static void pallindromePartition(String ques,String ans){
        if(ques.length() == 0)
            System.out.println(ans);
        else{
            for(int i = 1 ; i <= ques.length(); i++){
                String ch = ques.substring(0,i);
                if(isPallindrome(ch))
                    pallindromePartition(ques.substring(i),ans+ch+" ");
            }
        }
    }

    public static boolean isPallindrome(String input){
        int i = 0, j = input.length()-1;
        while(i < j){
            if(input.charAt(i) != input.charAt(j))
                return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
