package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    static List<List<Integer>> ans = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> al = new ArrayList<>();
        setCombSum(candidates,target,al,0);
        return ans;
    }

    public static void setCombSum(int[] candidates,int target,List<Integer> list,int last){

        if(target < 0)
            return;
        else if(target == 0)
            ans.add(new ArrayList<>(list));
        else{
            for(int i = last ; i < candidates.length ; i++){
                list.add(candidates[i]);
                setCombSum(candidates,target-candidates[i],list,i);
                list.remove(list.size()-1);
            }
        }
    }
}

