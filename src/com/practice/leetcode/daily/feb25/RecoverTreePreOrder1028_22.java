package com.practice.leetcode.daily.feb25;

import java.util.Stack;

public class RecoverTreePreOrder1028_22 {
    // TC : O(N)
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < traversal.length()) {
            int val = 0;
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++; // calculate - which is equal to depth
                i++;
            }
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))){
                val = val * 10 + (traversal.charAt(i) - '0'); // convert number from string
                i++;
            }
            TreeNode node = new TreeNode(val);

            while (stack.size() > depth) {
                stack.pop(); // remove element from stack to get correct parent
            }
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
