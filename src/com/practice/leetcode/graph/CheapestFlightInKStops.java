package com.practice.leetcode.graph;

import java.util.*;

public class CheapestFlightInKStops {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Map<Integer, List<int[]>> graph = buildGraph(n,flights);

            return dijkstra(n,graph,src,dst,k);
        }

        int dijkstra(int n, Map<Integer,List<int[]>> graph, int src, int dest, int k){
            int[] distances = new int[n];
            Arrays.fill(distances,Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if(a[2] == b[2])
                    return a[1]-b[1];
                else
                    return a[2]-b[2];
            });

            pq.offer(new int[]{src,0,0});
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int node = curr[0];
                int cost = curr[1];
                int stops = curr[2];
                if(stops > k)
                    continue;
                List<int[]> ngbrs = graph.get(node);
                for(int[] ngbr : ngbrs){
                    int nvalue = ngbr[0];
                    int ncost = ngbr[1];

                    int totalCost = cost+ncost;
                    if(totalCost<distances[nvalue]){
                        distances[nvalue]=totalCost;
                        pq.offer(new int[]{nvalue,totalCost,stops+1});
                    }
                }
            }
            return distances[dest] == Integer.MAX_VALUE ? -1 : distances[dest];
        }

        Map<Integer,List<int[]>> buildGraph(int n , int[][] flights){
            Map<Integer,List<int[]>> graph = new HashMap<>();

            for(int i = 0 ; i < n ; i++){
                graph.put(i,new ArrayList<>());
            }

            for(int[] flight : flights){
                int src = flight[0];
                int dest = flight[1];
                int cost = flight[2];

                graph.get(src).add(new int[]{dest,cost});
            }
            return graph;
        }
    }
}
