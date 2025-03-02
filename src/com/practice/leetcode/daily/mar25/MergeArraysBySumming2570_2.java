package com.practice.leetcode.daily.mar25;

import java.util.ArrayList;
import java.util.List;

public class MergeArraysBySumming2570_2 {
    // TC : O(N1+N2)
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0 , j = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (i < n && j < m) {
            if (nums1[i][0] == nums2[j][0]) {
                int sum = nums1[i][1] + nums2[j][1];
                result.add(List.of(nums1[i][0],sum));
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result.add(List.of(nums1[i][0],nums1[i][1]));
                i++;
            } else {
                result.add(List.of(nums2[j][0], nums2[j][1]));
                j++;
            }
        }
        while (i < n) {
            result.add(List.of(nums1[i][0],nums1[i][1]));
            i++;
        }
        while (j < m) {
            result.add(List.of(nums2[j][0], nums2[j][1]));
            j++;
        }

        int[][] res = new int[result.size()][2];
        for (int x = 0 ; x < result.size() ; x++) {
            res[x][0] = result.get(x).get(0);
            res[x][1] = result.get(x).get(1);
        }
        return res;
    }
}
