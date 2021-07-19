package com.practice.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class SmallerNumberThanCurrent {

    public static void main(String[] args) {
        int[] result = new int[]{8,1,2,2,3};
        int[] smallerNumbers = smallerNumbers(result);
        for(int i = 0 ; i < smallerNumbers.length ; i++)
            System.out.print(smallerNumbers[i]+" ");
    }

    //brute force
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int j = 0;
            count = 0;
            while(j < nums.length){
                if(nums[i] > nums[j] && i!=j){
                    count++;
                }
                j++;
            }
            result[i] = count;
        }
        return result;
    }
    //sort approach
    public static int[] smallerNumbers(int[] nums){
        int[] res = new int[nums.length];
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] =  nums[i];
        }

        Arrays.sort(temp);
        HashMap<Integer, Integer> f = new HashMap<>();

        for(int i = 0; i < temp.length; i++){ // O(n)
            if(!f.containsKey(temp[i])){ // O(1)
                f.put(temp[i], i); // O(1)
            }
        }

        for(int i = 0; i < nums.length; i++){ // O(n)
            res[i] = f.get(nums[i]);
        }

        return res;
    }

}
