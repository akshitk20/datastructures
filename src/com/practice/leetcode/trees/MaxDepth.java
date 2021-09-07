package com.practice.leetcode.trees;

public class MaxDepth {
    public int maxDepth(ZigZagOrder.TreeNode root) {
        if(root == null){
            return 0;
        }else
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
