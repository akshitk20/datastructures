package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionInterval {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0)
            return new int[0][];
        List<List<Integer>> result = new ArrayList<>();
        int i = 0 , j = 0;
        while (i < firstList.length && j < secondList.length) {
            // if they are overlapping take the intersection
            // intersection[0] = Max(first[0],second[0])
            // intersection[1] = Max(first[1], second[1])
            if (firstList[i][1] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) {
                List<Integer> ans = new ArrayList<>();
                ans.add(Math.max(firstList[i][0],secondList[j][0]));
                ans.add(Math.min(firstList[i][1],secondList[j][1]));
                result.add(ans);
            }
            // if first[1] < second [1] that means move first because we can get an intersection
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        //return result.toArray(new int[result.size()][]);
        int[][] res = new int[result.size()][result.get(0).size()];
        for(i = 0 ; i < result.size() ; i++){
            for(j = 0 ; j < result.get(i).size() ; j++){
                res[i][j] = result.get(i).get(j);
            }
        }
        return res;
    }
}
