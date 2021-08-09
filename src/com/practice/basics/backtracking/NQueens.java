package com.practice.basics.backtracking;

public class NQueens {

    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        System.out.println(nQueen(board,0,4,""));
    }

    private static int nQueen(boolean[][] board, int qpsf, int tq, String ans) {
        if(qpsf == tq){
            System.out.println(ans);
            return 1;
        }else{
            int count = 0;
            int row = qpsf;
            for(int col = 0 ; col < board[0].length ; col++){
                if(isItPossible(board,row,col)){
                    board[row][col] = true;
                    count+=nQueen(board,qpsf+1,tq,ans+" b"+row+col);
                    board[row][col] = false;
                }
            }
            return count;
        }

    }

    private static boolean isItPossible(boolean[][] board, int row, int col) {
        for(int i = 0; i < col; i++){
            if(board[row][i] == true)
                return false;
        }

        for(int i = 0 ; i < row ; i++){
            if(board[i][col] == true)
                return false;
        }
        int i = row -1;
        int j = col -1 ;
        while(i >= 0 && j >= 0){
            if(board[i][j] == true)
                return false;
            i--;
            j--;
        }

        i = row-1;
        j = col+1;
        while(i >= 0 && j < board[0].length){
            if(board[i][j] == true)
                return false;
            i--;
            j++;
        }

        return true;

    }
}
