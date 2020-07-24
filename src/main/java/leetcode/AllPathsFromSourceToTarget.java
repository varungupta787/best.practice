package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  797. All Paths From Source to Target    */

/*  https://leetcode.com/problems/all-paths-from-source-to-target/  */

/*
*
* Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []]
Output: [[0,1,3],[0,2,3]]
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Note:

The number of nodes in the graph will be in the range [2, 15].
You can print different paths in any order, but you should keep the order of nodes inside one path.
*
* */

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> out = new ArrayList<>();
        allPathsSourceTargetUtil(graph, 0, out, new ArrayList<>());
        return out;
    }

    public void allPathsSourceTargetUtil(int[][] graph, int src,
                                         List<List<Integer>> out, List<Integer> list) {

        if(src != Integer.MIN_VALUE) {
            list.add(src);
        }

        if(src == Integer.MIN_VALUE || graph[src] == null || graph[src].length == 0 ) {
            List<Integer> val = new ArrayList<>();
            val.addAll(list);
            out.add(val);
            return;
        }

        for(int dest : graph[src]) {
            if(dest != src) {
                allPathsSourceTargetUtil(graph, dest, out, list);
                list.remove(list.size()-1);
            } else {
                allPathsSourceTargetUtil(graph, Integer.MIN_VALUE , out, list);
            }
        }
    }
}
