package com.practice.leetcode.daily.mar25;

public class CheckPowerOfthree1780_4 {
    // recursive : 2 ^ n
    // iterative : log3n
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n = n / 3;
        }
        return true;
        //return checkPowersOfThree(0, n);
    }

    boolean checkPowersOfThree(int pow, int n) {
        if (n == 0) return true;
        if (n < 0 || n < (int) Math.pow(3,pow)) return false;

        boolean pick = checkPowersOfThree(pow+1, n - (int) Math.pow(3,pow));
        boolean notPick = checkPowersOfThree(pow+1, n);
        return pick || notPick;
    }
}
