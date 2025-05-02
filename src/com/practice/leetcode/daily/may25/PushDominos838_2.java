package com.practice.leetcode.daily.may25;

public class PushDominos838_2 {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int leftMostIndex = -1;
        for(int i = n-1 ; i >= 0 ; i--){
            char ch = dominoes.charAt(i);
            if(ch == 'L'){
                leftMostIndex = i;
            }else if(ch == 'R'){
                leftMostIndex = -1;
            }
            left[i] = leftMostIndex;
        }

        int[] right = new int[n];
        int rightMostIndex = -1;
        for(int i = 0 ; i < n ; i++){
            char ch = dominoes.charAt(i);
            if(ch == 'R'){
                rightMostIndex = i;
            }else if(ch == 'L'){
                rightMostIndex = -1;
            }
            right[i] = rightMostIndex;
        }

        char[] ch = new char[n];
        for(int i = 0 ; i < n ; i++){
            if(dominoes.charAt(i)=='.'){
                int nearestLeft = left[i];
                int nearestRight = right[i];

                int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs((nearestLeft-i));
                int rightDiff = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs((nearestRight-i));

                if(leftDiff == rightDiff){
                    ch[i] = '.';
                }else if(leftDiff < rightDiff){
                    ch[i] = 'L';
                }else if(leftDiff > rightDiff){
                    ch[i] = 'R';
                }
            }else{
                ch[i] = dominoes.charAt(i);
            }
        }
        return new String(ch);
    }
}
