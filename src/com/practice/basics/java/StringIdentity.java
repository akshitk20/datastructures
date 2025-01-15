package com.practice.basics.java;

public class StringIdentity {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        final String s3 = "He";
        String s4 = s3+"llo";
        String s5 = s1.intern(); // return a string if it finds it in the string pool
        System.out.println(s1 == s2);
        System.out.println(s1 == s4);
        System.out.println(s2 == s5);
    }
}
