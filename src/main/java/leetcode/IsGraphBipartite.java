package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*  785. Is Graph Bipartite?    */

/*  https://leetcode.com/problems/is-graph-bipartite/   */

/*
*
* Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B, such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.



Example 1:


Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:


Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: We cannot find a way to divide the set of nodes into two independent subsets.
*
* */

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        if(graph == null) {
            return false;
        }
        int n = graph.length;
        int[] colors = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< n; i++)  {
            if(graph[i] != null && graph[i].length > 0) {
                if(colors[i] == 0) {
                    colors[i] = 1;
                    queue.add(i);
                    while(!queue.isEmpty()) {
                        int size = queue.size();
                        while(size-- > 0) {
                            int src = queue.remove();
                            int color = colors[src];
                            for(int next : graph[src]) {
                                if(colors[next] == color) {
                                    return false;
                                } else {
                                    if(colors[next] == 0) {
                                        queue.add(next);
                                        colors[next] = -color;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
