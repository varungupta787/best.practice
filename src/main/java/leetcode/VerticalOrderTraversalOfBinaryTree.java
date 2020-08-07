package leetcode;

import java.util.*;

/*  987. Vertical Order Traversal of a Binary Tree  */

/*  https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/    */

/*
*
* Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.



Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.


Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
*
* */

public class VerticalOrderTraversalOfBinaryTree {

    static class Data {
        TreeNode node;
        int index;

        public Data(TreeNode i, int j) {
            node = i;
            index = j;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root != null) {
            Map<Integer, List<Integer>> map1 = new TreeMap<>();
            Map<Integer, List<Integer>> map = new TreeMap<>();
            Data dataVal = new Data(root, 0);

            Queue<Data> queue = new LinkedList<>();
            queue.add(dataVal);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Data data = queue.poll();
                    if (map.get(data.index) == null) {
                        map.put(data.index, new ArrayList<>());
                    }
                    List<Integer> temp = map.get(data.index);
                    temp.add(data.node.val);
                    map.put(data.index, temp);

                    if (data.node.left != null) {
                        queue.add(new Data(data.node.left, data.index - 1));
                    }
                    if (data.node.right != null) {
                        queue.add(new Data(data.node.right, data.index + 1));
                    }
                    size--;
                }
                Set<Integer> set = map.keySet();
                Iterator<Integer> itr = set.iterator();
                while (itr.hasNext()) {
                    int i = itr.next();
                    Collections.sort(map.get(i));
                    if (map1.get(i) == null) {
                        map1.put(i, new ArrayList<Integer>());
                    }
                    List<Integer> list = map1.get(i);
                    list.addAll(map.get(i));
                }
                map.clear();
            }

            out = new ArrayList<>(map1.values());
        }
        return out;
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
