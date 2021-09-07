package com.practice.leetcode.trees;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(ZigZagOrder.TreeNode root) {
        if(root == null)
            return -1;
        else{
            int l = diameterOfBinaryTree(root.left);
            int r = diameterOfBinaryTree(root.right);
            int d = height(root.left)+height(root.right)+2;
            return Math.max(l,Math.max(r,d));
        }
    }

    public int height(ZigZagOrder.TreeNode node){
        if(node == null)
            return -1;
        else
            return Math.max(height(node.left),height(node.right))+1;
    }
}
