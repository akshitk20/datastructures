package com.practice.leetcode.trees;

public class MinDepth {
    public int minDepth(ZigZagOrder.TreeNode root) {
        if(root == null)
            return 0;
        else
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
