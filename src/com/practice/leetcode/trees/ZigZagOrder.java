package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ZigZagOrder {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        ll.addFirst(root);
        int val = 0;
        while(!ll.isEmpty()){
            TreeNode node = ll.remove();
            if(val % 2 == 0){
                if(node.left != null)
                    temp.addFirst(node.left);
                if(node.right != null)
                    temp.addFirst(node.right);
            }else{
                if(node.right == null)
                    temp.addFirst(node.right);
                if(node.left == null)
                    temp.addFirst(node.left);
            }
            if(ll.isEmpty()){
                val++;
                List<Integer> list = new ArrayList<>();
                for(int i = 0 ; i < temp.size() ; i++){
                    list.add(temp.get(i).val);
                }
                result.add(list);
                ll = temp;
                temp = new LinkedList();
            }
        }

        return result;
    }
}
