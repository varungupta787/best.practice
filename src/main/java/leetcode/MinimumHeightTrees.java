package leetcode;

import java.util.*;

/*  310. Minimum Height Trees   */

/*  https://leetcode.com/problems/minimum-height-trees/ */

/*
*
* A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.

Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).

Return a list of all MHTs' root labels. You can return the answer in any order.

The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.



Example 1:


Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:


Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
Example 3:

Input: n = 1, edges = []
Output: [0]
Example 4:

Input: n = 2, edges = [[0,1]]
Output: [0,1]
*
* */

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(edges == null || edges.length == 0) {
            result.add(0);
            return result;
        }
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i=0; i<edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            if(graph[start] == null) {
                graph[start] = new HashSet<>();
            }
            graph[start].add(end);
            if(graph[end] == null) {
                graph[end] = new HashSet<>();
            }
            graph[end].add(start);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(graph[i].size() == 1) {
                queue.add(i);
            }
        }

        while(n>2) {
            int size = queue.size();
            n -= size;

            while (size-- > 0) {
                int node = queue.poll();
                int neighbour = graph[node].iterator().next();
                graph[neighbour].remove(node);
                if (graph[neighbour].size() == 1) {
                    queue.add(neighbour);
                }
            }
        }
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }
}
