package com.practice.leetcode.daily.jan25;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostOneValidPath1368_18 {
    //todo: fix this non working solution
    public int minCost(int[][] grid) {
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1, 0}};
        int[][] cost = new int[grid.length][grid.length];
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        queue.offer(new int[]{0,0,0});
        cost[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] val = queue.remove();
            int x = val[1];
            int y = val[2];
            int currentCost = val[0];
            if (cost[x][y] < currentCost) continue;
            for (int i = 0 ; i < 4 ; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int newCost = currentCost + (i != (grid[x][y] - 1) ? 1 : 0);
                if (newCost < cost[nx][ny]) {
                    cost[nx][ny] = newCost;
                    queue.offer(new int[] {nx,ny,newCost});
                }
            }
        }
        return cost[n-1][m-1];
    }
}
