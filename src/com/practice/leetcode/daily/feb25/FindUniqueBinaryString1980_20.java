package com.practice.leetcode.daily.feb25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindUniqueBinaryString1980_20 {

    List<String> list = new ArrayList<>();
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        String result = "";
        List<String> temp = new ArrayList<>(Arrays.asList(nums));
        solve(n, new StringBuilder());
        for (String num : list) {
            if (!temp.contains(num)) {
                result = num;
            }
        }
        return result;
    }

    public void solve(int n , StringBuilder ans) {
        if (n == 0) {
            list.add(ans.toString());
            return;
        }
        solve(n-1, ans.append("0"));
        ans.deleteCharAt(ans.length()-1);
        solve(n-1, ans.append("1"));
        ans.deleteCharAt(ans.length()-1);
    }
}
