package leetcode;

/*  96. Unique Binary Search Trees  */

/*  https://leetcode.com/problems/unique-binary-search-trees/   */

/*
*
* Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*
* */

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {

        int[] data = new int[n+1];
        data[0] = 1;
        data[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<i; j++) {
                data[i] += data[j]*data[i-j-1];
            }
        }
        return data[n];
    }
}
