package leetcode;

/*  230. Kth Smallest Element in a BST  */

/*  https://leetcode.com/problems/kth-smallest-element-in-a-bst/    */

/*
*
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*
* */

public class KSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        Data data = new Data();
        kthSmallestUtil(root, k, data);
        return data.value;
    }

    public boolean kthSmallestUtil(TreeNode root, int k, Data data) {
        if (root == null) {
            return false;
        }
        if (kthSmallestUtil(root.left, k, data)) {
            return true;
        }
        data.level++;
        if (data.level == k) {
            data.value = root.val;
            return true;
        }
        return kthSmallestUtil(root.right, k, data);
    }

    static class Data {
        private int level;
        private int value;

        Data() {
            this.level = 0;
            this.value = -1;
        }
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
