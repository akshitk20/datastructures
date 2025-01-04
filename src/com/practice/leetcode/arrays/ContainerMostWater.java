package com.practice.leetcode.arrays;

public class ContainerMostWater {
    // brute force
    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0 ; i < height.length ; i++) {
            for (int j = i+1; j < height.length ; j++){
                ans = Math.max(ans, Math.min(height[i],height[j]) * (j-i));
            }
        }
        return ans;
    }

    // 2 pointer
    public int maxArea2Pointer(int[] height) {
        int ans = 0;
        int i = 0;
        int j = height.length-1;
        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
