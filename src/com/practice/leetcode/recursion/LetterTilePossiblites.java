package com.practice.leetcode.recursion;

public class LetterTilePossiblites {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(int i = 0 ; i < tiles.length() ; i++){
            freq[tiles.charAt(i)-'A']++;
        }
        return totalCount(freq,"");

    }

    public int totalCount(int[] freq , String ans){
        int count = 0;
        if(!ans.isEmpty()){
            count = 1;
        }
        for(int i = 0 ; i < freq.length; i++){
            if(freq[i] != 0){
                freq[i]--;
                count += totalCount(freq,ans+(char)(i+'A'));
                freq[i]++;
            }
        }
        return count;

    }
}
