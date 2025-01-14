package com.practice.leetcode.daily.jan25;

import java.util.HashMap;
import java.util.Map;

public class PrefixCommonArray2657_14 {
    // O(N) put the frequency of each element in a hashmap
    // if freq == 2 then increment the count
    // if elements are same then do not increment count as count is already increased
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0 ; i < A.length ; i++) {
            map.put(A[i], map.getOrDefault(A[i],0) + 1);
            map.put(B[i], map.getOrDefault(B[i], 0) + 1);
            if (map.get(A[i]) == 2) {
                count++;
            }
            if ((A[i] != B[i]) && map.get(B[i]) == 2) {
                count++;
            }
            result[i] = count;
        }
        return result;
    }
}
