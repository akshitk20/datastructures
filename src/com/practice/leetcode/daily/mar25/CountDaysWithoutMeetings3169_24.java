package com.practice.leetcode.daily.mar25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountDaysWithoutMeetings3169_24 {
    // O(nlogn) + O(N)
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        List<int[]> temp = new ArrayList<>();
        int start = meetings[0][0];
        int end = meetings[0][1];
        for (int[] meeting : meetings) {
            if (end >= meeting[0]) {
                end = Math.max(end, meeting[1]);
            } else {
                temp.add(new int[] {start,end});
                start = meeting[0];
                end = meeting[1];
            }
        }
        temp.add(new int[] {start,end});
        int total = 0;
        for (int[] t : temp) {
            int sum = t[1]-t[0] + 1;
            total += sum;
        }

        return days-total;

    }
}
