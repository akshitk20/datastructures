package com.practice.leetcode.daily.mar25;

import java.util.*;

class Pair {
    long time;
    int node;
    public Pair(long time, int node) {
        this.time = time;
        this.node = node;
    }
}
public class NumberOfWaysToArriveAtDest1976_23 {
    // TC: O((E+V)LOGV)
    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0 ; i < n ; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[2],road[1]));
            adj.get(road[1]).add(new Pair(road[2],road[0]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.time));
        pq.offer(new Pair(0,0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long time = curr.time;
            int node = curr.node;
            for (Pair ngbr : adj.get(node)) {
                long ntime = ngbr.time;
                int adjNode = ngbr.node;

                if (time + ntime < dist[adjNode]) {
                    dist[adjNode] = time+ntime;
                    ways[adjNode] = ways[node];
                    pq.offer(new Pair(dist[adjNode], adjNode));
                } else if (time + ntime == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return (int) ways[n-1] % mod;
    }
}
