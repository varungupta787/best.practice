package leetcode;

/*  540. Single Element in a Sorted Array   */

/*  https://leetcode.com/problems/single-element-in-a-sorted-array/ */

/*
*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.



Example 1:

Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: [3,3,7,7,10,11,11]
Output: 10


Note: Your solution should run in O(log n) time and O(1) space.
*
* */


public class SingleElementinSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int size = nums.length;
        int result=0;
        int start = 0;
        int end = size-1;
        while(start < end) {
            int mid = start + (end-start)/2;
            if(nums[mid] == nums[mid^1]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
