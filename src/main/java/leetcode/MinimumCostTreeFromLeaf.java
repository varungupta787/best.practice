package leetcode;

/*  1130. Minimum Cost Tree From Leaf   */

/*  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/   */

/*
*
* Given an array arr of positive integers, consider all binary trees such that:

Each node has either 0 or 2 children;
The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.



Example 1:


Input: arr = [6,2,4]
Output: 32
Explanation: There are two possible trees shown.
The first has a non-leaf node sum 36, and the second has non-leaf node sum 32.
Example 2:


Input: arr = [4,11]
Output: 44

*
* */

public class MinimumCostTreeFromLeaf {
    public static void main(String[] args) {
        MinimumCostTreeFromLeaf aa = new MinimumCostTreeFromLeaf();
        int[] arr = new int[]{6, 2, 4};
        System.out.println(aa.mctFromLeafValues(arr));
    }

    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] data = new int[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int minValue = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    int leftMax = getMax(arr, j, k);
                    int rightMax = getMax(arr, k + 1, j + i);
                    int val = (leftMax * rightMax) +
                            data[j][k] +
                            data[k + 1][j + i];
                    if (minValue > val) {
                        minValue = val;
                    }
                }
                data[j][j + i] = minValue;
            }
        }
        return data[0][n - 1];
    }


    private int getMax(int[] arr, int s, int e) {
        int max = Integer.MIN_VALUE;
        for (int i = s; i <= e; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }
}
