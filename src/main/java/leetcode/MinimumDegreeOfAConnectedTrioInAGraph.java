package leetcode;

/*  1761. Minimum Degree of a Connected Trio in a Graph */

/*  https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/    */

/*
*
* You are given an undirected graph. You are given an integer n which is the number of nodes in the graph and an array edges, where each edges[i] = [ui, vi] indicates that there is an undirected edge between ui and vi.

A connected trio is a set of three nodes where there is an edge between every pair of them.

The degree of a connected trio is the number of edges where one endpoint is in the trio, and the other is not.

Return the minimum degree of a connected trio in the graph, or -1 if the graph has no connected trios.



Example 1:


Input: n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
Output: 3
Explanation: There is exactly one trio, which is [1,2,3]. The edges that form its degree are bolded in the figure above.
Example 2:


Input: n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
Output: 0
Explanation: There are exactly three trios:
1) [1,4,3] with degree 0.
2) [2,5,6] with degree 2.
3) [5,6,7] with degree 2.
*
*/


public class MinimumDegreeOfAConnectedTrioInAGraph {
    public int minTrioDegree(int n, int[][] edges) {
        int[] degree = new int[n+1];
        boolean[][] data = new boolean[n+1][n+1];

        for(int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            degree[start]++;
            degree[end]++;
            data[start][end] = true;
            data[end][start] = true;
        }

        int res = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            for(int j=i+1; j<=n; j++) {
                if(data[i][j]) {
                    for(int k=j+1; k<=n; k++) {
                        if(data[j][k] && data[i][k]) {
                            res = Math.min(res, (degree[i] +
                                    degree[j] +
                                    degree[k] - 6));
                        }
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE? -1 : res;
    }
}
