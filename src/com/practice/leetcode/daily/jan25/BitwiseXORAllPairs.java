package com.practice.leetcode.daily.jan25;

public class BitwiseXORAllPairs {
    // O(N + M)
    // X ^ X = 0 so if nums1 length is odd and nums2 length is even nums1 will cancel out
    // so we can use nums2 to calculate result and vice versa.
    // X ^ 0 = X
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;

        if ((nums1.length % 2) == 1) {
            for (int i = 0 ; i < nums2.length ; i++) {
                result = result ^ nums2[i];
            }
        }

        if ((nums2.length % 2) == 1) {
            for (int i = 0 ; i < nums1.length ; i++) {
                result = result ^ nums1[i];
            }
        }
        return result;
    }
}
