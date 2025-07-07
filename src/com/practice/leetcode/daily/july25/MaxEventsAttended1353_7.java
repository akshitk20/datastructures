package com.practice.leetcode.daily.july25;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEventsAttended1353_7 {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0]-b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int day = events[0][0];
        int count = 0;
        int n = events.length;
        int i = 0;

        while (i < n || !pq.isEmpty()) {

            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

            day++;
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
        }
        return count;
    }
}
