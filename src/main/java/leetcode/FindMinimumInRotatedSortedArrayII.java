package leetcode;

/*  154. Find Minimum in Rotated Sorted Array II    */

/*  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/  */

/*
*
* 154. Find Minimum in Rotated Sorted Array II
Hard

918

217

Add to List

Share
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
*
* */

public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else if (nums[mid] < nums[r]) r = mid;
            else r--;
        }
        return nums[l];
    }
}
