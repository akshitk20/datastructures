package com.practice.leetcode.arrays;

public class DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,7,6,0,2,0,7};
        duplicateZeros(arr);
    }

    public static void duplicateZeros(int[] arr) {
        int l = arr.length;
        int[] result = new int[l];
        int k = 0 ;
        for(int i = 0 ; i < l ; i++){
            if(arr[i] == 0){
                if(k == l)
                    break;
                result[k] = arr[i];
                if(k+1 == l)
                    break;
                result[k+1] = 0;
                k+=2;
            }else {
                if(k == l)
                    break;
                result[k++] = arr[i];
            }

        }
        for(int i = 0 ; i < l ; i++)
            System.out.print(result[i] +" ");
    }
}
