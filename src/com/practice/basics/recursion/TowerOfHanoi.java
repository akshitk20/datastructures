package com.practice.basics.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        toh(3,"A","C","B");
    }

    public static void toh(int n, String from, String to, String aux){
        if(n == 1){
            System.out.println("move disk"+n+ " from "+from+" to "+to);;
        }else{
            toh(n-1,from,aux,to); //n-1 disk from to aux
            System.out.println("move disk"+n+ " from "+from+" to "+to);
            toh(n-1,aux,to,from); //n-1 aux to
        }
    }
}
