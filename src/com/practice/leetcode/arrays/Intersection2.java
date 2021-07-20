package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = intersect(nums1, nums2);
        for (int i = 0; i < intersect.length; i++)
            System.out.print(intersect[i] + " ");
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        int[] result = new int[list.size()];

        for (i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
