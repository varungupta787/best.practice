package leetcode;

/*  https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/ */

/*  1235. Maximum Profit in Job Scheduling  */

/*
*
* We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.



Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job.
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job.
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
*
* */

import java.util.PriorityQueue;
import java.util.TreeMap;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[] dp = new int[n];
        int max = 0;

        PriorityQueue<Job> queue = new PriorityQueue<>((a, b) ->a.e-b.e);
        for(int i=0; i<n; i++) {
            queue.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        int k=0;
        while(!queue.isEmpty()) {
            Job job = queue.poll();
            startTime[k] = job.s;
            endTime[k] = job.e;
            profit[k] = job.p;
            k++;
        }

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0,0);

        for(int i=0; i<n; i++) {
            int lastEndTime = tm.floorKey(startTime[i]);
            int lastEndTimeProfit = tm.get(lastEndTime);
            max = Math.max(max, lastEndTimeProfit+profit[i]);
            tm.put(endTime[i], max);
        }
        return max;
    }

    static class Job {
        int s, e, p;
        public Job(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
}

