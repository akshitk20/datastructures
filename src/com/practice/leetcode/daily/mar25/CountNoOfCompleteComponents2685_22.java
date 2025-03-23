package com.practice.leetcode.daily.mar25;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class DisjointSet {
    int[] parent;
    int[] size;
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if (u == parent[u]) return parent[u];
        return parent[u] = findParent(parent[u]);
    }

    public void unionBySize(int u, int v) {
        int ultu = findParent(u);
        int ultv = findParent(v);
        if (size[ultu] < size[ultv]) {
            parent[ultu] = ultv;
            size[ultv] += size[ultu];
        } else {
            parent[ultv] = ultu;
            size[ultu] += size[ultv];
        }
    }
}
public class CountNoOfCompleteComponents2685_22 {
    public int countCompleteComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        Map<Integer, Integer> map = new HashMap<>();
        // connect components using edges
        for (int[] edge : edges) {
            ds.unionBySize(edge[0], edge[1]);
        }
        // count edges for each component
        for (int[] edge : edges) {
            int root1 = ds.findParent(edge[0]);
            int root2 = ds.findParent(edge[1]);
            if (root1 == root2) {
                map.put(root1, map.getOrDefault(root1,0)+1);
            }
        }
        // check if each component is complete
        int count = 0;
        for (int vertex = 0 ; vertex < n ; vertex++) {
            if (ds.findParent(vertex) == vertex) { // vertex is root
                int root = ds.findParent(vertex);
                int size = ds.size[root];
                int expectedEdges = (size * (size - 1)) / 2;
                if (map.getOrDefault(vertex, 0) == expectedEdges) {
                    count++;
                }
            }
        }
        return count;
    }
}
