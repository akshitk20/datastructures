package com.practice.basics.backtracking;

import java.util.Arrays;

public class RatInAMaze {

    public static void main(String[] args) {
        int[][] maze = {{0,1,0,0},{0,0,0,1},{0,0,1,0},{1,0,0,0},{1,1,0,1}};
        int[][] ans = new int[maze.length][maze[0].length];
        ratInMaze(maze,ans,0,0);
    }

    private static void ratInMaze(int[][] maze, int[][] ans, int currRow, int currCol) {

        if(currRow < 0 || currCol < 0 || currRow >= maze.length
                || currCol >= maze[0].length || maze[currRow][currCol] == 1)
            return;
        else if(currRow == maze.length - 1 && currCol == maze[0].length - 1){
            for(int[] val : ans){
                System.out.println(Arrays.toString(val));
            }
            System.out.println();
        }
        else{
            int[] row = {-1,0,1,0};
            int[] col = {0,1,0,-1};
            for(int i = 0 ; i < row.length ; i++){
                maze[currRow][currCol] = 1;
                ans[currRow][currCol] = 1;
                ratInMaze(maze,ans,currRow+row[i],currCol+col[i]);
                maze[currRow][currCol] = 0;
                ans[currRow][currCol] = 0;
            }
        }
    }

}
