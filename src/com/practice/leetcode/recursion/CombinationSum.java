package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> list1 = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        setCombinationSum(target, list1, candidates, 0);
//        list.add(list1);
        return list;
    }

    private static void setCombinationSum(int target, List<Integer> no, int[] candidates, int index) {
        if (target < 0)
            return;
        if (target == 0)
            list.add(no);
        else {
            no.add(candidates[index]);
            for (int i = index; i < candidates.length; i++) {
                setCombinationSum(target - candidates[i], no, candidates, i);
            }
        }
    }
}

