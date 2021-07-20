package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InversionCount {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2};
        System.out.println(getInversionCount(arr));
        System.out.println(mergeSortAndCount(arr,0,arr.length-1));
    }

    public static int getInversionCount(int[] arr){
        //O(n^2)
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 1 ; j < arr.length ; j++){
                if(arr[i] > arr[j] && i < j)
                    count++;
            }
        }
        return count;
    }

    //nlogn using merge sort
    public static int mergeSortAndCount(int[] arr,int l , int r){
        int count = 0;
        if(l < r){
            int m = (l+r)/2;

            count+=mergeSortAndCount(arr,l,m);
            count+=mergeSortAndCount(arr,m+1,r);
            count+=mergeAndCount(arr,l,m,r);
        }

        return count;
    }

    private static int mergeAndCount(int[] arr, int l, int m, int r) {
        int count = 0;
        int[] left = Arrays.copyOfRange(arr,l,m+1);
        int[] right = Arrays.copyOfRange(arr,m+1,r+1);
        int i = 0,j=0,k=l;

        while(i < left.length && j < right.length){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                count+=(m+1)-(l+i);
            }
        }
        while(i < left.length)
            arr[k++] = left[i++];
        while(j < right.length)
            arr[k++]  = right[j++];

        return count;
    }


}
