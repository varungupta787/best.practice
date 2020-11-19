package leetcode;

import java.util.Arrays;

/*  31. Next Permutation    */

/*  https://leetcode.com/problems/next-permutation/ */

/*
*
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
*
* */

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        if(nums.length == 1) {
            return;
        }
        int i = nums.length-1;

        while(i > 0) {
            if(nums[i-1] >= nums[i]) {
                i--;
            } else {
                break;
            }
        }
        if(i < 1) {
            Arrays.sort(nums);
            return;
        }

        if(i == nums.length-1) {
            int t = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = t;
            return;
        }


        int j = nums.length-1;
        while(j >= i) {
            if(nums[j] > nums[i-1] ) {
                int t = nums[i-1];
                nums[i-1] = nums[j];
                nums[j] = t;
                break;
            }
            j--;
        }

        j = nums.length-1;
        while(i < j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
        return;
    }
}
