package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountMatches {
    public static void main(String[] args) {
        List<List<String>> names = new ArrayList<>();
        names.add(List.of("phone","blue","pixel"));
        names.add(List.of("computer","silver","lenovo"));
        names.add(List.of("phone","gold","iphone"));
        System.out.println(countMatches(names,"color","silver"));
    }


    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        //item => type color name
        //rulekey => type rulevalue => 1st
        //rulekey => color rulevalue => 2nd
        //rulekey => name rulevalue => 3rd

        int count = 0;
        for(int i = 0 ; i < items.size() ; i++){
            if(ruleKey.equals("type")){
                if(ruleValue == items.get(i).get(0))
                    count++;
            }else if(ruleKey.equals("color")){
                if(ruleValue == items.get(i).get(1))
                    count++;
            }else{
                if(ruleValue.equals(items.get(i).get(2)))
                    count++;
            }

        }
        return count;

    }
}
