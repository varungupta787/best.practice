package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  78. Subsets */

/*  https://leetcode.com/problems/subsets/  */

/*
*
* Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*
* */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        if(nums == null) {
            return out;
        }

        int len = nums.length;
        int total = (int)Math.pow(2,len);

        for(int i=0; i< total; i++) {
            List<Integer> temp = new ArrayList();
            int j=0;
            while(j < len && ((1<<j) <= i)) {
                if(((1<<j) & i) > 0) {
                    temp.add(nums[j]);
                }
                j++;
            }
            out.add(temp);
        }
        return out;
    }
}
