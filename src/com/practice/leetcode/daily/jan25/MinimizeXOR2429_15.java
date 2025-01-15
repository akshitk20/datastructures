package com.practice.leetcode.daily.jan25;

public class MinimizeXOR2429_15 {
    // to check if bit set num & (1 << i) == 1
    // to set the bit : num = num | (1 << i)
    public int minimizeXor(int num1, int num2) {
        int bitSet = Integer.bitCount(num2); // java method to check the number of bit set
        int result = 0;
        for (int i = 31 ; i >= 0 && bitSet > 0; i--) {
            if ((num1 & (1<<i)) == 1) {
                result = result | (1<<i);
                bitSet--;
            }
        }

        for (int i = 0 ; i < 32 && bitSet > 0 ; i++) {
            if ((result & (1<<i)) != 1) {
                result = result | (1 << i);
                bitSet--;
            }
        }
        return result;
    }
}
