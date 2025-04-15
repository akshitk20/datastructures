package com.practice.leetcode.daily.april25;

public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for(int i = 0 ; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                int p1 = Math.abs(arr[i]-arr[j]);
                for (int k = j+1 ; k < n ; k++) {
                    int p2 = Math.abs(arr[j]-arr[k]);
                    int p3 = Math.abs(arr[i]-arr[k]);
                    if (p1 <= a && p2 <= b && p3 <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
