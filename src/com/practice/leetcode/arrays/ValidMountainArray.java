package com.practice.leetcode.arrays;

public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,8,9,10,11,12,11};
        System.out.println(validMountainArray(arr));
    }

    public static boolean validMountainArray(int[] arr) {
        int count = 0 , k = arr.length-1;
        for(int i = 0 ; i < arr.length ; i++){
            if(i+1 == arr.length)
                break;
            if(arr[i] == arr[i+1])
                count++;
        }

        if(count > 0)
            return false;
        if(arr.length <= 2)
            return false;

        for(int i = 0 ; i < arr.length ; i++){
            if(i >= k)
                return true;
            if(i+1 == arr.length)
                break;
            if(arr[i] < arr[i+1] && arr[k] < arr[k-1]){
                k--;
                i++;
            }else{
                break;
            }
        }
        return false;
    }
}
