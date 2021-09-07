package com.practice.leetcode.strings;

public class LongestPallindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        int count = -1;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i+1; j <= s.length(); j++){
                if(isPallindrome(s.substring(i,j))){
                    int length = s.substring(i, j).length();
                    if(count < length){
                        ans.replace(s.substring(i,j),ans);
                        count = length;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean isPallindrome(String input){
        int i = 0, j = input.length()-1;
        while(i <= j){
            if(input.charAt(i) != input.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
