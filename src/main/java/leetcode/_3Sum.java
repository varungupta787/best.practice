package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  15. 3Sum    */

/*  https://leetcode.com/problems/3sum/ */

/*
*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*
* */

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int i, j;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        for (i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = -nums[i];
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if ((nums[low] + nums[high]) == target) {
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if ((nums[low] + nums[high]) < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return list;
    }
}
