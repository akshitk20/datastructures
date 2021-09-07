package com.practice.leetcode.strings;

public class RemoveOccurences {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
    }
    public static String removeOccurrences(String s, String part) {
        String ans = "";
        String temp = s;
        boolean flag = false;
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j <= s.length(); j++){
                if(s.substring(i,j).equals(part)){
                    ans += temp.substring(0,i)+temp.substring(j);
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        return ans;
    }
}
