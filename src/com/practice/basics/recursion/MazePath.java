package com.practice.basics.recursion;

public class MazePath {
    public static void main(String[] args) {
        mazePath(2,2,0,0,"");
    }

    public static void mazePath(int er, int ec , int cr,int cc, String ans){
        if(cr == er && cc == ec){
            System.out.println(ans);
        }else if(cr > er || cc > ec)
            return;
        else{
            mazePath(er,ec,cr+1,cc,ans+"V");
            mazePath(er,ec,cr,cc+1,ans+"H");
        }
    }

    public static void mazePathDiagonal(int er, int ec , int cr,int cc, String ans){
        if(cr == er && cc == ec){
            System.out.println(ans);
        }else if(cr > er || cc > ec)
            return;
        else{
            mazePathDiagonal(er,ec,cr+1,cc,ans+"V");
            mazePathDiagonal(er,ec,cr,cc+1,ans+"H");
            mazePathDiagonal(er,ec,cr+1,cc+1,ans+"D");
        }
    }
}
