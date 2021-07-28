package com.practice.basics.recursion;

public class IncreasingDecreasingSequence {
    public static void main(String[] args) {
        pID(1,5);
    }

    public static void pID(int n1,int n2){
        if(n1 > n2)
            return;
        else{
            System.out.print(n1+" ");
            pID(n1+1,n2);
            System.out.print(n1+" ");
        }
    }
}
