package com.practice.leetcode.daily.feb25;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignNumberContainerSystem2349_9 {
    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    Map<Integer, Integer> numberMap = new HashMap<>();
    /*
    * Time complexity: O(logn) per change operation and O(1) per find operation.
    * The change operation involves updating two maps (indexToNumbers and numberToIndices) and performing operations on a set.
    * Checking and updating the maps takes O(1) time on average, but the set operations (adding or removing an index) take O(logk) time,
    * where k is the number of indices associated with a number. In the worst case, k can be n, so the change operation is O(logn).
    * The find operation is efficient because it only requires checking if a number exists in the set map (which is O(1)) and retrieving
    * the smallest index from the set (which is also O(1) due to the sorted nature of set). Thus, the find operation is O(1).
    *
    * */
    public void change(int index, int number) {
        if (numberMap.containsKey(index)) {
            Integer prev = numberMap.get(index);
            map.get(prev).remove(index);
            if (map.get(prev).isEmpty()) {
                map.remove(prev);
            }
        }
        numberMap.put(index, number);
        map.putIfAbsent(number, new TreeSet<>());
        map.get(number).add(index);
    }

    public int find(int number) {
        if (map.containsKey(number)) {
            return map.get(number).first(); // Get smallest index
        }
        return -1;
    }
}
