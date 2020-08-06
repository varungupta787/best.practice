package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  442. Find All Duplicates in an Array    */

/*  https://leetcode.com/problems/find-all-duplicates-in-an-array/  */

/*
*
* Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*
* */

public class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> out = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            if(nums[Math.abs(nums[i])-1] < 0) {
                out.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i])-1] *= -1;
            }
        }
        return out;
    }
}
