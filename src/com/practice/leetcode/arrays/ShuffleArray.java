package com.practice.leetcode.arrays;

import javax.management.MBeanRegistration;
import java.util.Arrays;

public class ShuffleArray {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,2,2};
        int[] result = shuffle(array, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int k = 0;
        for(int i = 0,j=n ; i < nums.length ; i++,j++,k+=2){
            if(k == nums.length)
                break;
            result[k] = nums[i];
            result[k+1] = nums[j];
        }
        return result;
    }
}
