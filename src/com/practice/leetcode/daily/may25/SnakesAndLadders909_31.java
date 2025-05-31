package com.practice.leetcode.daily.may25;


import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders909_31 {
    int n;
    public int snakesAndLadders(int[][] board) {
        int steps = 0;
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        visited[n-1][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int num = queue.poll();
                if (num == n * n) return steps;

                for (int i = 1 ; i <= 6 ; i++) {

                    int move = num + i;
                    if (move > n * n) break;

                    int[] coordinates = getCoordinates(move);

                    int r = coordinates[0];
                    int c = coordinates[1];

                    if (visited[r][c]) continue;

                    visited[r][c] = true;

                    if (board[r][c] == -1) {
                        queue.offer(move);
                    } else {
                        queue.offer(board[r][c]);
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    public int[] getCoordinates(int move) {
        int r = (move-1) / n;
        int bottomR = (n-1) - r;

        int c = (move-1) % n;

        if ((n % 2 == 1 && bottomR % 2 == 1) || (n % 2 == 0 && bottomR % 2 == 0)) {
            c = (n-1) - c;
        }
        return new int[]{bottomR, c};


    }
}
