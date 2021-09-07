package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(ZigZagOrder.TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }else{
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
            return list;
        }

    }
}
