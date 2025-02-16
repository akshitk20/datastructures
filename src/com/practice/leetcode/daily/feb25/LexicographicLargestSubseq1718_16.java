package com.practice.leetcode.daily.feb25;

import java.util.Arrays;

public class LexicographicLargestSubseq1718_16 {
    // TC(N!)
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[(n*2) - 1];
        Arrays.fill(result, 0);
        boolean[] visited = new boolean[n+1];
        generateSeq(result, visited, n ,0);
        return result;
    }

    public boolean generateSeq(int[] result, boolean[] visited, int n , int index) {
        if (index == result.length) return true;
        // already filled try for next index
        if (result[index] != 0) return generateSeq(result, visited, n, index+1);
        for (int num = n ; num >= 1 ; num--) {
            // for 1 we can place only once so index remains same else index becomes num+index
            int nextIndex = (num == 1 ? index : num+index);
            // visited check + boundary check
            if (visited[num] || (num > 1 && (nextIndex >= result.length || result[nextIndex] != 0)))
                continue;

            result[index] = num;
            result[nextIndex] = num;
            visited[num] = true;
            if (generateSeq(result,visited,n,index+1)) return true;
            // back track as not found
            result[index] = 0;
            result[nextIndex] = 0;
            visited[num] = false;
        }
        return false;
    }
}
