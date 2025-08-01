package com.practice.leetcode.daily.aug2025;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118_1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int row = 1 ; row <= numRows ; row++) {
            List<Integer> list = generateRow(row);
            result.add(list);
        }
        return result;
    }

    public List<Integer> generateRow(int row) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int ans = 1;
        for (int col = 1 ; col < row ; col++) {
            ans = ans * (row-col);
            ans = ans/col;
            list.add(ans);
        }
        return list;
    }
}
