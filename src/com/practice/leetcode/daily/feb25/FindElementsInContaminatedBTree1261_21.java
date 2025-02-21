package com.practice.leetcode.daily.feb25;

import java.util.HashSet;
import java.util.Set;
class TreeNode {
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
public class FindElementsInContaminatedBTree1261_21 {
    class FindElements {
        Set<Integer> set = new HashSet<>();
        public FindElements(TreeNode root) {
            recover(root,0);
        }

        public void recover(TreeNode root, int val) {
            if (root == null) return;
            set.add(val);
            if (root.left != null) {
                recover(root.left, 2*val+1);
            }
            if (root.right != null) {
                recover(root.right, 2*val+2);
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
