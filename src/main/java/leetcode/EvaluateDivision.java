package leetcode;

import java.util.*;

/*  399. Evaluate Division  */

/*  https://leetcode.com/problems/evaluate-division/    */

/*
*
* You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.



Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
*
* */

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = createGraph(equations, values);
        int size = queries.size();
        double[] res = new double[size];
        for(int i=0; i<size; i++) {
            res[i] = solveQueries(queries.get(i), graph);
        }
        return res;
    }

    private double solveQueries(List<String> path, Map<String, Map<String, Double>> graph) {
        double res = -1;
        if(path == null || path.size() == 1) {
            return res;
        }

        String start = path.get(0);
        String end = path.get(1);

        if(start == end) {
            return 1;
        }

        if(graph.get(start) == null || graph.get(end) == null) {
            return res;
        }


        Data sNode = new Data(start, 1);
        Queue<Data> queue = new LinkedList<>();
        queue.add(sNode);

        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                Data curr = queue.remove();
                String currNode = curr.node;
                double currVal = curr.val;
                if(currNode.equals(end)) {
                    return currVal;
                }
                for(Map.Entry<String, Double> nextEntry :
                        graph.get(curr.node).entrySet()) {
                    String key = nextEntry.getKey();
                    double val = nextEntry.getValue();
                    if(!visited.contains(key)) {
                        queue.add(new Data(key, currVal*val));
                    }
                }
                visited.add(curr.node);
            }
        }
        return res;
    }

    private Map<String, Map<String, Double>> createGraph(
            List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for(int i=0; i< equations.size(); i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            if(graph.get(src) == null) {
                HashMap<String, Double> node = new HashMap<>();
                graph.put(src, node);
            }
            graph.get(src).put(dest, values[i]);

            if(graph.get(dest) == null) {
                HashMap<String, Double> node = new HashMap<>();
                graph.put(dest, node);
            }
            graph.get(dest).put(src, 1/(Double)values[i]);
        }
        return graph;
    }

    static class Data {
        String node;
        double val;
        Data(String node, double val) {
            this.node = node;
            this.val= val;
        }
    }
}
