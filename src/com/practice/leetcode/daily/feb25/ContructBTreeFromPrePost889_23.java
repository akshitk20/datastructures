package com.practice.leetcode.daily.feb25;

public class ContructBTreeFromPrePost889_23 {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructFromPrePost(preorder, 0 , n-1, postorder, 0 , n-1);
    }

    public TreeNode constructFromPrePost(int[] preorder, int psi, int pse, int[] postorder, int ppsi, int ppse) {
        if (psi > pse) return null;
        TreeNode root = new TreeNode(preorder[psi]);
        if (psi == pse) return root; // if only one element
        int idx = ppsi;
        while (postorder[idx] != preorder[psi+1]) { // look for next index from preorder in postorder
            idx++;
        }
        int total = idx-ppsi+1; // calculate total elements (b-a+1)
        // left subtree
        root.left = constructFromPrePost(preorder,psi+1,psi+total,postorder,ppsi,idx);
        // right subtree
        root.right = constructFromPrePost(preorder, psi+total+1,pse, postorder, idx+1, ppse-1);
        return root;
    }
}
