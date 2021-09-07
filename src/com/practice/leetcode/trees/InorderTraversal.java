package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(ZigZagOrder.TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        else{
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
            return list;
        }
    }
}
