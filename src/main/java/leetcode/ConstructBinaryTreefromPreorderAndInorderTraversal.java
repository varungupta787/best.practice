package leetcode;

import java.util.HashMap;

/*  105. Construct Binary Tree from Preorder and Inorder Traversal  */

/*  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/    */

/*
*
* Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*
* */

public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = preorder.length;
        for(int i=0; i<len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorder, 0, 0, len-1, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int index, int start, int end,
                              HashMap<Integer, Integer> map) {
        if(start < 0 || end >= preorder.length
                || start > end ||
                index < 0 || index >= preorder.length) {
            return null;
        }
        int val = preorder[index];
        TreeNode node = new TreeNode(val);
        int i = map.get(val);
        node.left = buildTree(preorder, inorder, index+1, start, i-1, map);
        node.right = buildTree(preorder, inorder, index + (i-start) + 1, i+1, end, map);
        return node;
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
