package com.practice.basics.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(facTail(5,1));
    }

    public static int fact(int n){ //fact(5)
        if(n == 0)      //n=0 return 1;
            return 1;
        else{
            return n * fact(n-1); //5 * fact(4)
        }
    }

    public static int facTail(int n,int ans){ //fact(5)
        if(n == 0)      //n=0 return 1;
            return ans;  //calc ans and return at last return ans
        else{
            return facTail(n-1, ans*n); //5 * fact(4)
        }
    }
}
