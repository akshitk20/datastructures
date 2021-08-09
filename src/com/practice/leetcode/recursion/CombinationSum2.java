package com.practice.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        setCombSum(candidates,target,list,0);
        return result;
    }

    public void setCombSum(int[] candidates,int target,List<Integer> list, int last){
        if(target == 0)
            result.add(new ArrayList<>(list));
        else if(target < 0)
            return;
        else{
            for(int i = last ; i < candidates.length ; i++){
                if(i == last || candidates[i] != candidates[i-1]){
                    list.add(candidates[i]);
                    setCombSum(candidates,target-candidates[i],list,i+1);
                    list.remove(list.size()-1);
                }
            }
        }

    }
}
