package com.practice.leetcode.arrays;

public class NumbersWithEvenDigits {
    public static int findNumbers(int[] nums) {
        int count = 0;
        int rem = 0;
        int n;
        for(int i = 0 ; i < nums.length ; i++){
            n = nums[i];
            while(n > 0){
                n = n/10;
                rem++;
            }
            if(rem % 2 == 0)
                count++;
            rem = 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{437,315,322,431,686,264,442};
        System.out.println(findNumbers(nums));
    }

}
