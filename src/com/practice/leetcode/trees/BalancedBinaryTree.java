package com.practice.leetcode.trees;

public class BalancedBinaryTree {
    public boolean isBalanced(ZigZagOrder.TreeNode root) {
        if(root == null)
            return true;
        else{
            boolean isb = true;
            if(Math.abs(height(root.left)-height(root.right)) > 1)
                isb = false;
            return isb && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(ZigZagOrder.TreeNode node){
        if(node == null)
            return -1;
        else
            return Math.max(height(node.left),height(node.right))+1;
    }
}
