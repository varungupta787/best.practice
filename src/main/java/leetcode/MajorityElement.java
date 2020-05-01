package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  229. Majority Element II    */

/*  https://leetcode.com/problems/majority-element-ii/  */

/*
* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
*
* */


public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return result;

        int first = nums[0], count1 = 1, second = first, count2 = 0;

        for (int i = 1; i < len; i++) {

            if (first == nums[i]) {
                count1++;
            } else if (second == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                first = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                second = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < len; i++) {

            if (first == nums[i]) {
                count1++;
            } else if (second == nums[i]) {
                count2++;
            }
        }

        if (count1 > len / 3)
            result.add(first);

        if (count2 > len / 3)
            result.add(second);

        return result;
    }
}