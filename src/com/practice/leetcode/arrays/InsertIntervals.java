package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        // nonoverlapping as interval ends before new interval begins
        while (i < n && newInterval[0] > intervals[i][1]) {
            result.add(intervals[i]);
            i++;
        }

        // overlapping and merging
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        //nonoverlapping as the newInterval ends before interval starts
        while (i < n && newInterval[1] < intervals[i][0]) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
