package com.practice.leetcode.daily.jan25;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak1765_22 {
    // O(n*m) multi source BFS
    public int[][] highestPeak(int[][] isWater) {
        int[][] height = new int[isWater.length][isWater[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] h : height) {
            Arrays.fill(h, -1);
        }
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0} , {-1,0}};
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.add(new int[] {i,j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.remove();
            int x = node[0];
            int y = node[1];
            for (int[] dir : dirs) {
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || height[nx][ny] != -1)
                    continue;
                height[nx][ny] = height[x][y] + 1;
                queue.offer(new int[] {nx,ny});
            }
        }

        return height;
    }
}
