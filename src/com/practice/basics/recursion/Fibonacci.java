package com.practice.basics.recursion;

public class Fibonacci {
    //11235813..
    public static void main(String[] args) {
        System.out.println(fib(3));
        System.out.println(fibTail(3,0,1));
    }

    public static int fib(int n){
        if(n == 0 || n == 1)
            return n;
        else
            return fib(n-1)+fib(n-2);//smaller problem fib(n-1) + fib(n-2)
    }

    public static int fibTail(int n,int a,int b){
        if(n == 0)
            return b;
        else
            return fibTail(n-1,b,a+b); //a=b , b = a+b swapping
    }
}
