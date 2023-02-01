package com.practice.leetcode.strings;

public class GcdOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(!((str1+str2).equals(str2+str1))){
            return "";
        }
        int gcd = gcd(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }

    int gcd(int a, int b){
        if(a == 0)  return b;
        else{
            return gcd(b%a,a);
        }
    }
}
