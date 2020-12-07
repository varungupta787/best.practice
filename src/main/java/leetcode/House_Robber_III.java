package leetcode;

/*  337. House Robber III   */

/*  https://leetcode.com/problems/house-robber-iii/ */

/*
*
* The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
*
* */

public class House_Robber_III {
    public int rob(TreeNode root) {
        Model data = robUtil(root);
        return Math.max(data.curr, data.prev);
    }

    public Model robUtil(TreeNode root) {

        if (root == null) {
            return new Model();
        }

        Model data1 = robUtil(root.left);
        Model data2 = robUtil(root.right);

        int curr = data1.prev + data2.prev + root.val;
        int prev = data1.curr + data2.curr;
        data1.curr = Math.max(curr, prev);
        data1.prev = prev;
        return data1;
    }

    static class Model {
        int curr = 0;
        int prev = 0;
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
