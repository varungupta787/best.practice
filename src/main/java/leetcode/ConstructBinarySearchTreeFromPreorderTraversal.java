package leetcode;

/*  1008. Construct Binary Search Tree from Preorder Traversal  */

/*  https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/     */

/*
*
* Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]



Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.
*
* */

public class ConstructBinarySearchTreeFromPreorderTraversal {
    int index = 0;
    int size = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        size = preorder.length;
        return bstFromPreorderUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorderUtil(int[] preOrder, int min, int max) {
        if (index >= size) {
            return null;
        }
        TreeNode node = null;
        int key = preOrder[index];
        if (preOrder[index] > min && preOrder[index] < max) {
            node = new TreeNode(preOrder[index]);
            index++;
            node.left = bstFromPreorderUtil(preOrder, min, key);
            node.right = bstFromPreorderUtil(preOrder, key, max);
        }
        return node;
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
