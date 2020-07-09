package leetcode;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/*  662. Maximum Width of Binary Tree   */

/*  https://leetcode.com/problems/maximum-width-of-binary-tree/ */

/*
*
* Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).



*
* */

public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            Pair<TreeNode, Integer> first = queue.peek();
            Pair <TreeNode, Integer>curr = null;
            while(size > 0) {
                curr = queue.remove();
                TreeNode node = curr.getKey();
                int index = curr.getValue();
                if(node.left != null) {
                    queue.add(new Pair(node.left, 2*index));
                }
                if(node.right != null) {
                    queue.add(new Pair(node.right, 2*index+1));
                }
                size--;
            }
            maxWidth = Math.max(maxWidth, (curr.getValue() - first.getValue() +1));
        }
        return maxWidth;
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
