package leetcode;

/*  226. Invert Binary Tree */

/*  https://leetcode.com/problems/invert-binary-tree/   */

/*
*
*Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
*
* */


public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invertTreeUtil(root);
        return root;
    }

    public void invertTreeUtil(TreeNode root) {
        if (null == root) {
            return;
        }
        invertTreeUtil(root.left);
        invertTreeUtil(root.right);
        TreeNode val = root.left;
        root.left = root.right;
        root.right = val;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
