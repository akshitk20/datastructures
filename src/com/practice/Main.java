package com.practice;

import com.practice.basics.arrays.DynamicArray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DynamicArray dynamicArray = new DynamicArray(6);
        dynamicArray.add(1);
        dynamicArray.add(5);
        dynamicArray.add(3);

        System.out.println(dynamicArray.toString());

        dynamicArray.remove(3);

        System.out.println(dynamicArray.toString());

        dynamicArray.removeAt(1);

        System.out.println(dynamicArray.size());

    }
}
