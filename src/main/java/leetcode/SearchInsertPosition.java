package leetcode;

/*  35. Search Insert Position  */

/*  https://leetcode.com/problems/search-insert-position/   */

/*
*
* Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*
* */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len == 0 || target < nums[0]) {
            return 0;
        }
        if(target > nums[len-1]) {
            return len;
        }
        int start=0, end = len-1, mid = 0;

        while (start <= end) {
            mid = start + (end-start)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        if(nums[mid] < target) {
            return mid+1;
        } else {
            return mid;
        }
    }
}
