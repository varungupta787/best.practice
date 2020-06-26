package leetcode;

/*  129. Sum Root to Leaf Numbers   */

/*  https://leetcode.com/problems/sum-root-to-leaf-numbers/ */

/*
*
* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
*
* */

public class SumRootToLeafNumbers {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbersUtil(root, 0);
        return sum;
    }

    public void sumNumbersUtil(TreeNode root, int val) {

        if (root.left == null && root.right == null) {
            sum += (10 * val) + root.val;
            return;
        }
        int temp = (10 * val) + root.val;
        if (root.left != null)
            sumNumbersUtil(root.left, temp);
        if (root.right != null)
            sumNumbersUtil(root.right, temp);
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
