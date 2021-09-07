package com.practice.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        int[] greaterElements = nextGreaterElements(arr);
        System.out.println(Arrays.toString(greaterElements));
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < nums.length; i++){
            while(!stack.empty() && nums[i] > nums[stack.peek()]){
                int id = stack.pop();
                ans[id] = nums[i];
            }
            while(!stack.empty()){
                int id = stack.pop();
                ans[id] = -1;
            }

            stack.push(i);
        }
        return ans;
    }
}
