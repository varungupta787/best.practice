package leetcode;

/*  110. Balanced Binary Tree   */

/*  https://leetcode.com/problems/balanced-binary-tree/ */

/*
*
* Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true

*
* */

public class BalancedBinaryTree {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        isBalancedUtil(root);
        return result;
    }



    public int isBalancedUtil(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null) {
            left = isBalancedUtil(root.left);
        }
        if(root.right != null) {
            right = isBalancedUtil(root.right);
        }
        if(Math.abs(left-right) > 1) {
            result = false;
        }

        return 1+Math.max(left, right);
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
