package leetcode;

/*  145. Binary Tree Postorder Traversal    */

/*  https://leetcode.com/problems/binary-tree-postorder-traversal   */

/*
*
* Given the root of a binary tree, return the postorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [3,2,1]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
*
* Constraints:

The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
*
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while(root != null) {
            stk.push(root);
            root = root.left;
        }

        TreeNode curr = null;

        while(!stk.isEmpty()) {
            TreeNode peek = stk.peek();
            if(peek.right == curr) {
                curr = stk.pop();
                res.add(curr.val);
            } else if(peek.right != null) {
                stk.push(peek.right);
                root = peek.right.left;

                while(root !=null) {
                    stk.push(root);
                    root = root.left;
                }
            } else {
                curr = stk.pop();
                res.add(curr.val);
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
