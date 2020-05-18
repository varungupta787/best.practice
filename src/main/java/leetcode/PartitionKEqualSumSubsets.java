package leetcode;


/*  698. Partition to K Equal Sum Subsets   */

/*  https://leetcode.com/problems/partition-to-k-equal-sum-subsets/ */

/*
*
* Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.



Example 1:

Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.


Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
*
* */


public class PartitionKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int size = nums.length;
        int sum = 0;

        if(size < k || k == 0) {
            return false;
        }

        if(k == 1) {
            return true;
        }

        for(int i=0; i<size; i++) {
            sum += nums[i];
        }

        if((sum%k) != 0){
            return false;
        }

        boolean[] select = new boolean[size];
        return canPartitionKSubsetsHelper(nums, k, 0, select, sum/k, sum/k);

    }


    public boolean canPartitionKSubsetsHelper(int[] nums, int k, int start,
                                              boolean[] select, int sumRemain, int sum) {

        if(sumRemain < 0 || start>= nums.length) {
            return false;
        }

        if(k == 1) {
            return true;
        }

        if(sumRemain == 0) {
            return canPartitionKSubsetsHelper(nums, k-1, 0, select, sum, sum);
        }

        for(int i=start; i< nums.length; i++) {
            if(!select[i]) {
                select[i] = true;
                if(canPartitionKSubsetsHelper(nums, k, i+1, select, sumRemain-nums[i], sum)) {
                    return true;
                }
                select[i] = false;
            }
        }
        return false;
    }

}
