package com.practice.leetcode.daily.jan25;

public class WaysToSplitArray2270_3 {

    /*
    * A common question that arises is how to recognize when to use the prefix sum technique.
    * Suppose you're walking along a path, and someone asks how far you are from a point you passed earlier.
    * Instead of counting the steps back, you just subtract the distance from where you are now to the point in question.
    * This is what the prefix sum does. By using it, we can answer multiple queries in constant time, which reduces the
    * computation time from a multiplication factor of q to just addition for each query.
    *
    * To generalize, when a problem requires answering multiple queries, and each query involves some form of range aggregation
    * where each aggregate builds on the previous one, the prefix sum is often a good fit, such as the sum of a subarray,
    * the product of a range, counting from a range or finding averages.
    * */
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        int sum = 0;
        long prefix[] = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        for (int i = 0 ; i < nums.length -1 ; i++) {
            // sum from 0 to i
            long lsum = prefix[i];
            // sum from i to n-1;
            long rsum = prefix[nums.length-1] - prefix[i];
            if (lsum >= rsum)
                count++;
        }
        return count;
    }

}
