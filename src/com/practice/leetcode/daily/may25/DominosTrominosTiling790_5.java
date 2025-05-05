package com.practice.leetcode.daily.may25;

import java.util.Arrays;

public class DominosTrominosTiling790_5 {
    int mod = (int)Math.pow(10,9)+7;
    public int numTilings(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return (int)numTilings(n,dp)%mod;
    }

    public long numTilings(int n , long[] dp){
        if(n == 0)
            return 1;
        if(n < 3)
            return n;
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = 2*numTilings(n-1,dp)%mod+numTilings(n-3,dp)%mod;
    }
}
