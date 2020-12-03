package leetcode;

/*  34. Find First and Last Position of Element in Sorted Array */

/*  https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/  */

/*
*
* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*
* */

public class FindFirstAndLastPositionofElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int len = nums.length;
        if(len >= 1) {
            searchRangeUtil(nums, target, 0, len-1, res);
        }
        if(res[0] == Integer.MAX_VALUE) {
            res[0] = -1;
        }
        if(res[1] == Integer.MIN_VALUE) {
            res[1] = -1;
        }
        return res;
    }

    public void searchRangeUtil(int[] nums, int target, int start, int end, int[] res) {
        if(start < 0 || end > nums.length-1 || start > end ||
                !(target >= nums[start] && target <= nums[end])) {
            return;
        }

        int mid = start + (end-start)/2;

        if(nums[mid] == target){
            res[0] = Math.min(mid, res[0]);
            res[1] = Math.max(mid, res[1]);
        }

        searchRangeUtil(nums, target, start, mid-1, res);
        searchRangeUtil(nums, target, mid+1, end, res);
    }
}
