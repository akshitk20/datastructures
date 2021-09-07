package com.practice.leetcode.recursion;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        subsets(nums,list);
        return result;
    }

    private static void subsets(int[] nums, List<Integer> list) {
        if(nums.length == 0){
            result.add(new ArrayList<>(list));
        }else{
            for(int i = 0 ; i < nums.length ; i++){
                int num = nums[i];
                boolean flag = true;
                for(int j = 0 ; j < i ; j++){
                    if(nums[j] == num){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(num);
                    subsets(Arrays.copyOfRange(nums,1,nums.length),list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
