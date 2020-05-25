package leetcode;

import java.util.Arrays;


/*  416. Partition Equal Subset Sum     */

/*  https://leetcode.com/problems/partition-equal-subset-sum/   */

/*
*
* Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

Each of the array element will not exceed 100.
The array size will not exceed 200.


Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].


Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*
* */

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int sum = 0;
        for(int i=0; i<size; i++) {
            sum += nums[i];
        }

        if(sum %2 != 0) {
            return false;
        }

        sum = sum/2;

        boolean[] map = new boolean[sum + 1];
        map[0] = true;
        for (int i = 1; i <= size; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                map[j] |= map[j - nums[i - 1]];
            }
        }
        return map[sum];
    }
}
