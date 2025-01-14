package com.practice.basics.java;

public class ThingExample {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1;
        System.out.println(s1);
        System.out.println(s2);
        s2 = s2.concat("World!");
        System.out.println(s1);
        System.out.println(s2);

        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = sb1;
        System.out.println(sb1);
        System.out.println(sb2);
        sb2.append("World");
        System.out.println(sb1);
        System.out.println(sb2);
    }
}
