package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        permuteUnique(nums);
        System.out.println(result);
    }


    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        setPermutations(nums,list);
        return result;
    }

    public static void setPermutations(int[] nums,List<Integer> list){
        if(nums.length == 0)
            result.add(new ArrayList<>(list));

        else{
            for(int i = 0 ; i < nums.length ; i++){
                int num = nums[i];
                boolean flag = true;
                for(int j = 0 ; j < i ; j++){
                    if(nums[j]==num){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(num);
                    int[] nq = mergeArray(Arrays.copyOfRange(nums,0,i),Arrays.copyOfRange(nums,i+1,nums.length));
                    setPermutations(nq,list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
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
