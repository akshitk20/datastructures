package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        setPermutations(nums,list);
        return result;
    }

    public void setPermutations(int[] nums, List<Integer> list){
        if(nums.length == 0){
            result.add(new ArrayList<>(list));
        }else{
            for(int i = 0 ; i < nums.length ; i++){
                list.add(nums[i]);
                int[] nq = mergeArray(Arrays.copyOfRange(nums,0,i),Arrays.copyOfRange(nums,i+1,nums.length));
                setPermutations(nq,list);
                list.remove(list.size()-1);
            }
        }
    }

    private int[] mergeArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];

        int i = 0 , j= 0 , k = 0;
        while(i < arr1.length){
            result[k] = arr1[i];
            k++;
            i++;
        }
        while(j < arr2.length){
            result[k] = arr2[j];
            k++;
            j++;
        }
        return result;
    }
}
