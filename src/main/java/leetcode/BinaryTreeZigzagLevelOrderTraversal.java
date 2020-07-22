package leetcode;

import java.util.*;

/*  103. Binary Tree Zigzag Level Order Traversal   */

/*  https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/ */

/*
*
* Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*
* */

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> out = new ArrayList<>();
        if(root == null) {
            return out;
        }
        queue.add(root);
        boolean isRev = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> data = new ArrayList<>();
            while(size > 0) {
                TreeNode node = queue.poll();
                data.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            if(isRev) {
                Collections.reverse(data);
            }
            isRev = !isRev;
            out.add(data);
        }
        return out;
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
