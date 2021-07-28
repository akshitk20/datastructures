package com.practice.basics.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class AllOccurenceOfElement {
    public static void main(String[] args) {
        int[] arr =  new int[]{3,2,4,1,2,3};
        printAllOccurrence(arr,0,2);
        System.out.println();
        ArrayList<Integer> list = new ArrayList<>();
        storeAllOccurrence(arr,0,3,list);
        System.out.print(list);
        System.out.println();
        System.out.println(Arrays.toString(storeAllOccurrence1(arr,0,3,0)));
    }

    public static void printAllOccurrence(int arr[], int id, int elem){
        if(arr.length == id)
            return;
        else
        if(arr[id] == elem)
            System.out.print(id+" ");
        printAllOccurrence(arr,id+1,elem);
    }


    public static void storeAllOccurrence(int[] arr, int id, int elem, ArrayList<Integer> list){
        if(arr.length == id)
            return;
        else{
            if(arr[id] == elem){
                list.add(id);
            }
            storeAllOccurrence(arr,id+1,elem,list);
        }
    }

    //return array with all occurence size of array = no of occurrences
    public static int[] storeAllOccurrence1(int[] arr,int id,int ele,int count) {
        if (id == arr.length) {
            int[] ans = new int[count];
            return ans;   //return address
        } else {                                   //[1,2,3,2,4] =>
            if (arr[id] == ele)
                count++;
            int[] indexArray = storeAllOccurrence1(arr, id + 1, ele, count); //returns address same address as ans
            if (arr[id] == ele) {
                indexArray[count - 1] = id;  //12324
            }
            return indexArray;
        }
    }
}
