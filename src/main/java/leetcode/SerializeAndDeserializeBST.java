package leetcode;

/*  449. Serialize and Deserialize BST  */

/*  https://leetcode.com/problems/serialize-and-deserialize-bst/    */

/*
*
* Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.



Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.
*
* */


public class SerializeAndDeserializeBST {
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(root.val + " ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] preorder = data.split(" ");
        return helper(preorder, 0, preorder.length - 1);
    }

    public TreeNode helper(String[] preorder, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(Integer.parseInt(preorder[start]));
        int index;
        for(index = start; index <= end; index++) {
            if(Integer.parseInt(preorder[index]) > Integer.parseInt(preorder[start]))
                break;
        }

        root.left = helper(preorder, start + 1, index - 1);
        root.right = helper(preorder, index, end);

        return root;
    }

    static  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
