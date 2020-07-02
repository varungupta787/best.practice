package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*  107. Binary Tree Level Order Traversal II   */

/*  https://leetcode.com/problems/binary-tree-level-order-traversal-ii/ */

/*
*
* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*
* */

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while(size > 0) {
                TreeNode node = queue.remove();
                temp.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                size--;
            }
            res.add(0, temp);
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
