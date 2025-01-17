package com.practice.leetcode.daily.jan25;

public class NeighbouringBitwiseXOR2683_17 {
    // O(N)
    // X ^ X = 0
    // if value of XOR is 0 then it is possibility
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int d : derived)
            xor = xor ^ d;
        return xor == 0;
    }
}
