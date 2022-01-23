package leetcode;

/*  101. Symmetric Tree */

/*  https://leetcode.com/problems/symmetric-tree/   */

/*
*
* Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false
*
* */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root.left, root.right);
    }


    public boolean isSymmetricUtil(TreeNode left, TreeNode  right) {
        if(left == null || right == null) {
            return (left == null && right == null);
        }

        if(left.val != right.val) {
            return false;
        }

        return isSymmetricUtil(left.left, right.right) &&
                isSymmetricUtil(left.right, right.left);
    }

    static public class TreeNode {
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
}