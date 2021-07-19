package com.practice.leetcode.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SquaresOfSortedArray {
    public int[] sortedSquare(int[] nums){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length ; i++)
            result.add(nums[i] * nums[i]);

        Collections.sort(result);
        for(int i = 0 ; i < nums.length; i++)
            nums[i] = result.get(i);
        return nums;
    }
}
