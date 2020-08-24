package leetcode;

/*  404. Sum of Left Leaves */

/*  https://leetcode.com/problems/sum-of-left-leaves/   */

/*
*
* Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*
* */


public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return sumOfLeftLeavesUtil(root, false);
    }

    public int sumOfLeftLeavesUtil(TreeNode root, boolean isLeft) {

        if(root == null) {
            return 0;
        }
        if(isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        int sum = 0;
        if(root.left != null) {
            sum += sumOfLeftLeavesUtil(root.left, true);
        }
        if(root.right != null) {
            sum += sumOfLeftLeavesUtil(root.right, false);
        }
        return sum;
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
