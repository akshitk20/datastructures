package com.practice.leetcode.arrays;

public class BusyStudents {
    public static void main(String[] args) {
        int[] startTime = new int[]{16};
        int[] endTime = new int[]{60};
        System.out.println(busyStudent(startTime,endTime,58));
    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for(int i = 0 ; i < startTime.length; i++){
            int start = startTime[i];
            int end = endTime[i];
            for(int j = start ; j <= end ; j++){
                if (j == queryTime)
                    count++;
            }
        }
        return count;
    }
}
