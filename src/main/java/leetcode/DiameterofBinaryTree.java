package leetcode;

/*  543. Diameter of Binary Tree    */

/*  https://leetcode.com/problems/diameter-of-binary-tree/  */

/*
*
* Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*
* */

public class DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = diameterOfBinaryTreeUtil(root);
        return ((res[0] == 0) ? 0 : res[0]-1);
    }

    public int[] diameterOfBinaryTreeUtil(TreeNode root) {
        if(root == null) {
            return new int[]{0,0};
        }
        int left[] = diameterOfBinaryTreeUtil(root.left);
        int right[] = diameterOfBinaryTreeUtil(root.right);
        int val = left[1]+right[1]+1;
        left[0] = Math.max(val, left[0]);
        left[0] = Math.max(left[0], right[0]);
        left[1] = Math.max(left[1], right[1])+1;
        return left;
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
