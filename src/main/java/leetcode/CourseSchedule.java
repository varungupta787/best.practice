package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*  207. Course Schedule    */

/*  https://leetcode.com/problems/course-schedule/  */

/*
*
* There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*
* */


public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // adjency list based graph initalization
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        int[] indegree = new int[numCourses];
        for(int[] e: prerequisites) {
            graph[e[0]].add(e[1]); // adding directed edge
            indegree[e[1]]++; // indegree update for courses
        }

        // queue intilalization and fill all courses having 0 indegree or no prerequisites
        Queue<Integer> queue = new LinkedList();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }

        // BFS traversal until finish all course or can't take more courses
        while(!queue.isEmpty()) {
            int current = queue.poll();
            for(int c : graph[current]) {
                indegree[c]--;
                if(indegree[c] == 0)
                    queue.add(c);
            }
            numCourses--;
        }
        return numCourses == 0; // check if all courses taken
    }
}