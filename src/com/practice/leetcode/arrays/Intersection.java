package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i:nums1){
            hashSet.add(i);
        }

        for (int i:nums2){
            if (hashSet.contains(i)){
                arrayList.add(i);
                hashSet.remove(i);
            }
        }

//        int []arr = new int[arrayList.size()];
//        int k =0;
//        for (int i: arrayList){
//            arr[k] = i;
//            k++;
//        }
//
//        return arr;
        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }
}
