package leetcode;


/*  95. Unique Binary Search Trees II   */

/*  https://leetcode.com/problems/unique-binary-search-trees-ii/description/    */

/*
*
*Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]
*
*/


import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        for(int i =0; i<n; i++) {
            arr[i] = i+1;
        }
        List<TreeNode> result = getTree(arr, 0, n-1);

        return result;
    }

    private List<TreeNode> getTree(int[] arr, int l, int r) {
        List<TreeNode> result = new ArrayList<>();
        if(l< 0 || r >= arr.length || l > r) {
            result.add(null);
            return result;
        }

        if(l == r) {
            TreeNode curr = new TreeNode(arr[l]);
            result.add(curr);
            return result;
        }
        for(int i=l; i<=r; i++) {
            List<TreeNode> left = getTree(arr, l, i-1);
            List<TreeNode> right = getTree(arr, i+1, r);

            for(TreeNode l1 : left) {
                for(TreeNode r1 : right) {
                    TreeNode curr = new TreeNode(arr[i]);
                    curr.left = l1;
                    curr.right = r1;
                    result.add(curr);
                }
            }
        }
        return result;
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