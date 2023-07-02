package leetcode;

/*  https://leetcode.com/problems/maximal-network-rank/description/ */

/*  1615. Maximal Network Rank  */

/*
*
* There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi] indicates that there is a bidirectional road between cities ai and bi.

The network rank of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.

The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.

Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.



Example 1:



Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
Output: 4
Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1. The road between 0 and 1 is only counted once.
Example 2:



Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
Output: 5
Explanation: There are 5 roads that are connected to cities 1 or 2.
Example 3:

Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
Output: 5
Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.

*
* */


import java.util.HashSet;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        HashSet<Integer>[] graph = createGraph(n, roads);
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = 0;
                if (graph[i] != null && graph[j] != null) {
                    temp = graph[i].size() + graph[j].size();
                    if (graph[i].contains(j)) {
                        temp--;
                    }
                }
                maxRank = Math.max(maxRank, temp);
            }
        }
        return maxRank;
    }

    private HashSet<Integer>[] createGraph(int n, int[][] roads) {
        HashSet<Integer>[] graph = new HashSet[n];
        for (int[] road : roads) {
            if (graph[road[0]] == null) {
                graph[road[0]] = new HashSet<>();
            }
            graph[road[0]].add(road[1]);

            if (graph[road[1]] == null) {
                graph[road[1]] = new HashSet<>();
            }
            graph[road[1]].add(road[0]);
        }
        return graph;
    }
}
