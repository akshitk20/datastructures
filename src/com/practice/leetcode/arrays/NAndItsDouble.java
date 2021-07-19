package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class NAndItsDouble {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,7,11,0};
        System.out.println(checkIfExist(arr));
    }
    public static boolean checkIfExist(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++)
            list.add(arr[i]);

        for(int i = 0 ; i < arr.length ; i++){
            if(list.get(i) == 0)
                count++;
        }

        for(int i = 0  ; i < arr.length ; i++){
            if(count > 1)
                return true;
            if(list.contains(arr[i] * 2) && !(arr[i] * 2 == 0))
                return true;
        }
        return false;

    }
}
