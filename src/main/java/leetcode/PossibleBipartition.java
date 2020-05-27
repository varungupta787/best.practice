package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  886. Possible Bipartition   */

/*  https://leetcode.com/problems/possible-bipartition/     */

/*
*
* Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.



Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false


Note:

1 <= N <= 2000
0 <= dislikes.length <= 10000
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].
*
* */


public class PossibleBipartition {

    private static enum Colour {
        BLUE, RED;
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0) return true;

        MyGraph g = new MyGraph(N+1);
        for (int[] d : dislikes) {
            g.addEdge(d[0], d[1]);
        }
        Colour[] colours = new Colour[N+1];
        for (int u = 1; u <= N; u++) {
            if (colours[u] == null) {
                if (!isBipartite(g, u, colours, Colour.RED))
                    return false;
            }
        }
        return true;
    }


    private static class MyGraph {
        int V;
        List<Integer>[] adj;
        public MyGraph(int V) {
            this.V = V;
            this.adj = (List<Integer>[])new ArrayList[V];
            for (int u = 0; u < V; u++) {
                adj[u] = new ArrayList<>();
            }
        }
        public void addEdge(int u, int v) {
            this.adj[u].add(v);
            this.adj[v].add(u);
        }

    }

    public boolean isBipartite(MyGraph g, int u, Colour[] colours, Colour colour) {
        colours[u] = colour;
        Colour nextColour = (colour == Colour.RED) ? Colour.BLUE : Colour.RED;
        for (int v : g.adj[u]) {
            if (colours[v] == null) {
                if (!isBipartite(g, v, colours, nextColour))
                    return false;
            }
            else if (colours[v] == colour)
                return false;
        }
        return true;
    }
}
