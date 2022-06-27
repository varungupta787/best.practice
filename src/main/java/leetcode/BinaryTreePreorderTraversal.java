package leetcode;

/*  144. Binary Tree Preorder Traversal */

/*  https://leetcode.com/problems/binary-tree-preorder-traversal/   */

/*
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = null;
        if(root != null) {
            stk.push(root);
        }

        while(!stk.isEmpty()) {
            curr = stk.pop();
            res.add(curr.val);
            if(curr.right != null) {
                stk.push(curr.right);
            }
            if(curr.left != null) {
                stk.push(curr.left);
            }
        }
        return res;
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
