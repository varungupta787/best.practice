package leetcode;

/*  https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/description/  */

/*  1986. Minimum Number of Work Sessions to Finish the Tasks   */

/*
*
* There are n tasks assigned to you. The task times are represented as an integer array tasks of length n, where the ith task takes tasks[i] hours to finish. A work session is when you work for at most sessionTime consecutive hours and then take a break.

You should finish the given tasks in a way that satisfies the following conditions:

If you start a task in a work session, you must complete it in the same work session.
You can start a new task immediately after finishing the previous one.
You may complete the tasks in any order.
Given tasks and sessionTime, return the minimum number of work sessions needed to finish all the tasks following the conditions above.

The tests are generated such that sessionTime is greater than or equal to the maximum element in tasks[i].



Example 1:

Input: tasks = [1,2,3], sessionTime = 3
Output: 2
Explanation: You can finish the tasks in two work sessions.
- First work session: finish the first and the second tasks in 1 + 2 = 3 hours.
- Second work session: finish the third task in 3 hours.
Example 2:

Input: tasks = [3,1,3,1,1], sessionTime = 8
Output: 2
Explanation: You can finish the tasks in two work sessions.
- First work session: finish all the tasks except the last one in 3 + 1 + 3 + 1 = 8 hours.
- Second work session: finish the last task in 1 hour.
Example 3:

Input: tasks = [1,2,3,4,5], sessionTime = 15
Output: 1
Explanation: You can finish all the tasks in one work session.
*
* */

public class MinimumNumberOfWorkSessionsToFinishTheTasks {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int[][] temp = new int[1<<n][2];
        temp[0][0] = 1;
        temp[0][1] = 0;

        for(int i=1; i<(1<<n); i++) {
            temp[i][0] = Integer.MAX_VALUE;
            for(int j=0; j<n; j++) {
                if((i & 1<<j) == 0) {
                    continue;
                }
                int[] prev = temp[i^(1<<j)];
                int[] curr = new int[2];
                if(prev[1]+ tasks[j] <= sessionTime) {
                    curr[0] = prev[0];
                    curr[1] = prev[1]+ tasks[j];
                    temp[i] = min(curr, temp[i]);
                } else {
                    curr[0] = prev[0]+1;
                    curr[1] = tasks[j];
                    temp[i] = min(curr, temp[i]);
                }
            }
        }
        return temp[(1<<n)-1][0];
    }

    private int[] min(int[] a , int[] b) {
        if(a[0] < b[0]) {
            return a;
        } else if(a[0] > b[0]) {
            return b;
        }
        if(a[1] < b[1]) {
            return a;
        }
        return b;
    }
}
