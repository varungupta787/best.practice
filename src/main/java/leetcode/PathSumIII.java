package leetcode;

import java.util.*;

/*  437. Path Sum III   */

/*  https://leetcode.com/problems/path-sum-iii/ */

/*
*
* You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*
* */

public class PathSumIII {
    int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfs(root, sum, 0, map);
        return cnt;
    }

    void dfs(TreeNode root, int sum, int total,
             Map<Integer, Integer> map) {

        if (root == null) return;
        total += root.val;
        if (map.containsKey(total - sum)) {
            cnt += map.get(total - sum);
        }
        map.put(total, map.getOrDefault(total, 0) + 1);

        dfs(root.left, sum, total, map);
        dfs(root.right, sum, total, map);
        map.put(total, map.get(total) - 1);
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
