package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Intersection3 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 10, 20, 40, 80};
        int[] arr2 = new int[]{6, 7, 20, 80, 100};
        int[] arr3 = new int[]{3, 4, 15, 20, 30, 70, 80, 120};
        int[] intersect = intersect(arr1, arr2, arr3);
        for(int i: intersect){
            System.out.print(i+" ");
        }
    }

    public static int[] intersect(int[] arr1, int[] arr2, int[] arr3){
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[Math.min(arr1.length,arr2.length)];
        int i = 0 , j = 0 , k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                arr[k] = arr1[i];
                i++;
                j++;
                k++;
            }else if(arr1[i] < arr2[j])
                i++;
            else
                j++;
        }
        i=0;
        j=0;
        while(i < arr.length && j < arr3.length){
            if(arr[i] == arr3[j]){
                list.add(arr[i]);
                i++;
                j++;
            }else if(arr[i] < arr3[j])
                i++;
            else
                j++;
        }
        int[] result = new int[list.size()];
        for(int x = 0 ; x < list.size() ; x++){
            result[x]= list.get(x);
        }
        return result;
    }
}
