package com.practice.leetcode.daily.may25;

import java.util.Arrays;

public class FindClosestNodeToTwoGivenNode2359_30 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];

        dist1[node1] = 0;
        dist2[node2] = 0;

        dfs(node1, edges, dist1, visited1);
        dfs(node2, edges, dist2, visited2);

        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < n ; i++) {
            int max = Math.max(dist1[i], dist2[i]);
            if (min > max) {
                min = max;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void dfs(int node, int[] edges, int[] dist, boolean[] visited) {
        visited[node] = true;
        int v = edges[node]; // only one ngbr

        if (v == -1 || visited[v]) return;

        dist[v] = 1 + dist[node];
        dfs(v, edges,dist,visited);
    }
}
