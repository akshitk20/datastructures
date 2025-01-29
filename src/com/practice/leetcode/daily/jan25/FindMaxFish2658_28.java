package com.practice.leetcode.daily.jan25;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxFish2658_28 {
    // O(m*n)
    // loop through matrix and apply bfs for every surrounding
    // keep track of max
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    count = Math.max(count, bfs(grid, i , j , visited));
                }
            }
        }
        return count;
    }

    public int bfs(int[][] grid, int row, int col, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row,col});
        visited[row][col] = true;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
        int count = 0;
        while (!queue.isEmpty()) {
            int[] ele = queue.remove();
            count += grid[ele[0]][ele[1]];
            for (int[] dir : dirs) {
                int nx = dir[0] + ele[0];
                int ny = dir[1] + ele[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >=m || visited[nx][ny] || grid[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny});
            }
        }
        return count;
    }
}
