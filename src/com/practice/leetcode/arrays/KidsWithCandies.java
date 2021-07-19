package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = new int[]{12,1,12};
        List<Boolean> booleanList = kidsWithCandies(candies, 3);
        System.out.println(booleanList.toString());

    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for(int i = 0 ; i < candies.length ; i++){
            if(max < candies[i])
                max = candies[i];
        }
        for(int i = 0 ; i < candies.length ; i++){
            if(candies[i] + extraCandies >= max)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

}
