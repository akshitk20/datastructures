package com.practice.leetcode.arrays;

public class Decode {

    public static void main(String[] args) {
        int[] encoded = new int[]{1,2,3};
        int[] result = decode(encoded,1);
        for(int i = 0 ; i < result.length ; i++)
            System.out.print(result[i]+" ");
    }

    public static int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length+1];
        arr[0] = first;
        for(int i = 1 ; i < arr.length ; i++){
            arr[i] = arr[i-1]^encoded[i-1];
        }
        return arr;
    }
}
