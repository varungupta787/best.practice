package leetcode;

/*  124. Binary Tree Maximum Path Sum   */

/*  https://leetcode.com/problems/binary-tree-maximum-path-sum/ */

/*
*
* Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any node sequence from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.



Example 1:


Input: root = [1,2,3]
Output: 6
Example 2:


Input: root = [-10,9,20,null,null,15,7]
Output: 42
*
* */

public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return max;
    }

    public int maxPathSumUtil(TreeNode root) {

        if(root == null)  {
            return 0;
        }
        int left = maxPathSumUtil(root.left);
        max = Math.max(max, left + root.val);
        int right = maxPathSumUtil(root.right);
        max = Math.max(max, right + root.val);
        max = Math.max(max, left+right+root.val);
        max = Math.max(max, root.val);
        return Math.max(root.val, Math.max(right + root.val,  left + root.val));
    }

    static  public class TreeNode {
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
