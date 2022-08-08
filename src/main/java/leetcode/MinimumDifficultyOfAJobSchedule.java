package leetcode;

/*  1335. Minimum Difficulty of a Job Schedule  */

/*  https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/ */

/*
*
* You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).

You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.

You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].

Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
*
* */


import java.util.Arrays;

public class MinimumDifficultyOfAJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d) {
            return -1;
        }
        int[][] dp = new int[n][d];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return minDifficultyUtil(jobDifficulty, d, dp, 0);

    }

    public int minDifficultyUtil(int[] jobDifficulty, int d,
                                 int[][] dp, int index) {
        if(index >= jobDifficulty.length) {
            return Integer.MIN_VALUE;
        }
        if(dp[index][d-1] != -1) {
            return dp[index][d-1];
        }

        int max = 0;
        if(d == 1) {
            for(int i=index; i<jobDifficulty.length; i++) {
                max = Math.max(max, jobDifficulty[i]);
            }
            dp[index][d-1] = max;
            return max;
        }

        int res = Integer.MAX_VALUE;
        for(int i=index; i<=jobDifficulty.length-d; i++) {
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max+
                    minDifficultyUtil(jobDifficulty, d-1, dp, i+1));
        }
        return dp[index][d-1] = res;
    }
}
