package com.practice.leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,0,0,0};
        int[] arr1 = new int[]{2,5,6};
        merge(arr,3,arr1,3);
    }
    public static void merge(int[] nums1 , int m, int[] nums2, int n){
        int k = 0;
        for(int i = m ; i < m+n ; i++){
            nums1[i] = nums2[k++];
        }
        Arrays.sort(nums1);

        for(int x = 0 ; x < m+n ; x++){
            System.out.print(nums1[x]+" ");
        }

    }

}
