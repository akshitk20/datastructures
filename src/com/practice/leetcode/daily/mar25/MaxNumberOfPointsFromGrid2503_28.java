package com.practice.leetcode.daily.mar25;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfPointsFromGrid2503_28 {
    // TC : TLE
    public int[] maxPointsDFS(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[queries.length];
        for (int i = 0 ; i < queries.length ; i++) {
            int query = queries[i];
            boolean[][] visited = new boolean[n][m];
            int[] count = new int[1];
            dfs(grid, 0, 0 , query, visited, count);
            ans[i] = count[0];
        }
        return ans;
    }

    public void dfs(int[][] grid, int r, int c, int query, boolean[][] visited, int[] count) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] >= query || visited[r][c]) return;
        visited[r][c] = true;
        count[0]++;
        dfs(grid, r+1 , c , query, visited, count);
        dfs(grid, r-1 , c , query, visited, count);
        dfs(grid, r , c+1 , query, visited, count);
        dfs(grid, r , c-1 , query, visited, count);
    }

    // TC : O(klogk+n⋅mlog(n⋅m))
    //all n⋅m cells are processed and pushed into the heap.
    // Each heap operation (push or pop) takes O(log(n⋅m)) time.
    // Therefore, processing all cells takes O(n⋅mlog(n⋅m)).
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[queries.length];
        int[][] dirs = {{0,1}, {0,-1}, {1,0} , {-1, 0}};

        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0 ; i < queries.length ; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[] {grid[0][0], 0 , 0});

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        int count = 0;

        for (int[] query : sortedQueries) {
            int val = query[0];
            int index = query[1];

            while (!pq.isEmpty() && pq.peek()[0] < val) {
                int[] curr = pq.poll();
                int cellValue = curr[0];
                int r = curr[1];
                int c = curr[2];
                count++;

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) continue;
                    pq.offer(new int[] {grid[nr][nc], nr, nc});
                    visited[nr][nc] = true;
                }
            }
            ans[index] = count;
        }
        return ans;
    }
}
