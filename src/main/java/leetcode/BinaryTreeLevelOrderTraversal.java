package leetcode;

/*  102. Binary Tree Level Order Traversal  */

/*  https://leetcode.com/problems/binary-tree-level-order-traversal/    */

/*
*
* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int size = 0;

            while(!queue.isEmpty()) {
                size = queue.size();
                List<Integer> list = new ArrayList<>();
                while(size > 0) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null) {
                        queue.add(node.left);
                    }
                    if(node.right != null) {
                        queue.add(node.right);
                    }
                    size--;
                }
                res.add(list);
            }
        }
        return res;
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
