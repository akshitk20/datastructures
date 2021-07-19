package com.practice.leetcode.arrays;

public class ShuffleString {
    public static void main(String[] args) {
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(restoreString("codeleet",indices));
    }

    public static String restoreString(String s, int[] indices) {
       char[] chars = new char[indices.length];

       for(int i = 0 ; i < chars.length ; i++)
           chars[indices[i]] = s.charAt(i);

       return String.valueOf(chars);
    }
}
