package leetcode;

import java.util.HashMap;

/*  560. Subarray Sum Equals K  */

/*  https://leetcode.com/problems/subarray-sum-equals-k/    */

/*
*
* Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*
* */

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int len  = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += nums[i];
            if(sum == k) {
                res++;
            }

            if(map.containsKey(sum-k)) {
                res += map.get(sum-k);
            }

            if(map.get(sum) != null) {
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1);
            }
        }
        return res;
    }
}
