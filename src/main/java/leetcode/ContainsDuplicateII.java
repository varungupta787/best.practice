package leetcode;

/*  https://leetcode.com/problems/contains-duplicate-ii/    */

/*  219. Contains Duplicate II  */

/*
*
* Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*
* */

import java.util.HashMap;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Integer index = null;
        HashMap<Integer, Integer> data = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            index = data.get(nums[i]);
            if(index != null) {
                if(Math.abs(index-i) <= k) {
                    return true;
                }
            }
            data.put(nums[i], i);
        }
        return false;
    }
}
