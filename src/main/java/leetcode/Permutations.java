package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  46. Permutations    */

/*  https://leetcode.com/problems/permutations/ */

/*
*
* Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*
* */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(nums, 0, res);
        return res;
    }

    public void permute(int[] nums, int i, List<List<Integer>> out) {
        if(i >= nums.length-1) {
            List<Integer> res = new ArrayList<>();
            for(int k=0; k< nums.length; k++) {
                res.add(nums[k]);
            }
            out.add(res);
            return;
        }

        for(int k=i; k < nums.length; k++) {
            swap(nums, i, k);
            permute(nums, i+1, out);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
