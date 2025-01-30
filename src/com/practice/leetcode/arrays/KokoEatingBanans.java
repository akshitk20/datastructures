package com.practice.leetcode.arrays;

public class KokoEatingBanans {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int p : piles) {
            high = Math.max(high, p);
        }
        while (low <= high) {
            int mid = (high+low)/2;
            if (isPossible(piles, mid, h)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] piles, int mid, int k) {
        int total = 0;
        for (int i = 0 ; i < piles.length ; i++) {
            total += (int) Math.ceil(piles[i]*1.0/mid);
        }
        return total <= k;
    }

    public static void main(String[] args) {
        int[] piles = new int[] {3,6,7,11};
        System.out.println(minEatingSpeed(piles, 8));
    }
}
