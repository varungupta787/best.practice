package leetcode;

import java.util.HashMap;

/*  128. Longest Consecutive Sequence   */

/*  https://leetcode.com/problems/longest-consecutive-sequence/ */

/*
*
* Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Follow up: Could you implement the O(n) solution?



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*
* */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int len= nums.length;
        if(len == 0) {
            return 0;
        }
        HashMap<Integer, String> map  = new HashMap<>();
        for(int i=0; i<len; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], "");
            }
        }
        int res = 0;
        for(int i=0; i<len; i++) {
            if(map.get(nums[i]) != null) {
                int c = 1;
                int val = nums[i]-1;
                while(map.get(val) != null) {
                    map.put(val, null);
                    c++;
                    val--;
                }
                val = nums[i]+1;
                while(map.get(val) != null) {
                    map.put(val, null);
                    c++;
                    val++;
                }
                res = Math.max(res, c);
            }
        }
        return res;
    }
}
