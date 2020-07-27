package leetcode;

import java.util.HashMap;

/*  106. Construct Binary Tree from Inorder and Postorder Traversal */

/*  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/   */

/*
*
* Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*
* */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(len == 1) {
            return new TreeNode(inorder[0]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeUtil(postorder, 0, len-1, map, len-1);
    }

    public TreeNode buildTreeUtil(int[] postorder, int start, int end,
                                  HashMap<Integer, Integer> map, int postIndex) {

        if(start <= end && postIndex > -1) {
            int i = map.get(postorder[postIndex]);
            TreeNode node = new TreeNode(postorder[postIndex]);
            TreeNode right =
                    buildTreeUtil(postorder, i+1, end, map, postIndex-1);
            TreeNode left =
                    buildTreeUtil(postorder, start, i-1, map, postIndex - (end-i)-1);
            node.left = left;
            node.right = right;
            return node;
        }
        return null;
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