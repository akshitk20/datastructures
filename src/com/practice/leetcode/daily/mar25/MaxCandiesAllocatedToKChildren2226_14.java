package com.practice.leetcode.daily.mar25;

public class MaxCandiesAllocatedToKChildren2226_14 {
    // binary search on ranges
    // O(nlogm)
    public int maximumCandies(int[] candies, long k) {
        // binary search on ranges
        long sum = 0;
        for (int c : candies) sum += c;
        int low = 1;
        int high = (int) sum;
        int ans = 0;
        while (low <= high) {
            int mid = (low+high)/2;
            if (isPossible(candies, mid, k)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] candies, int mid, long k) {
        long sum = 0;
        for (int i = 0 ; i < candies.length ; i++) {
            sum += (candies[i] / mid);
        }
        return sum >= k;
    }
}
