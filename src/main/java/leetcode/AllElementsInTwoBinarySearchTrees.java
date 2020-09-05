package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*  1305. All Elements in Two Binary Search Trees   */

/*  https://leetcode.com/problems/all-elements-in-two-binary-search-trees/  */

/*
*
* Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.



Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]


Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
*
* */

public class AllElementsInTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> s1 = new Stack();
        Stack<TreeNode> s2 = new Stack();

        leftSubtree(root1, s1);
        leftSubtree(root2, s2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode r1 = s1.peek();
            TreeNode r2 = s2.peek();
            if (r1.val > r2.val) {
                result.add(r2.val);
                s2.pop();
                leftSubtree(r2.right, s2);
            } else {
                result.add(r1.val);
                s1.pop();
                leftSubtree(r1.right, s1);
            }

        }

        while (!s1.isEmpty()) {
            TreeNode r = s1.pop();
            result.add(r.val);
            leftSubtree(r.right, s1);
        }

        while (!s2.isEmpty()) {
            TreeNode r = s2.pop();
            result.add(r.val);
            leftSubtree(r.right, s2);
        }

        return result;
    }

    private void leftSubtree(TreeNode root, Stack<TreeNode> s) {
        if (root == null)
            return;
        s.add(root);
        leftSubtree(root.left, s);
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
