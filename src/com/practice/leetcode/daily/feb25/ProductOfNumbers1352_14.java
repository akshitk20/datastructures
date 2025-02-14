package com.practice.leetcode.daily.feb25;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers1352_14 {
    // TC: for one operation O(1) for n operation O(N)
    // prefix sum technique
    List<Integer> list = new ArrayList<>();
    int size = 0;

    public ProductOfNumbers1352_14() {
        this.list.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            this.list = new ArrayList<>();
            this.list.add(1);
            this.size = 0;
        } else {
            this.list.add(this.list.get(size) * num);
            this.size++;
        }
    }
    public int getProduct(int k) {
        if (k > this.size) {
            return 0;
        } else {
            return this.list.get(size)/this.list.get(size-k);
        }
    }
}
