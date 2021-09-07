package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(ZigZagOrder.TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        else{
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
            return list;
        }
    }
}
