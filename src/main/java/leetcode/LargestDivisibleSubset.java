package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  368. Largest Divisible Subset    */

/*  https://leetcode.com/problems/largest-divisible-subset/ */

/*
*
* Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*
* */

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        ArrayList<Integer> result = new ArrayList<>();

        if(len == 0) {
            return result;
        }
        int[] count = new int[len];

        Arrays.sort(nums);

        for(int i=0; i< len; i++) {
            count[i] = 1;
        }

        int maxCountIndex = 0;

        for(int i=1; i<len ; i++) {
            for(int j=i-1; j>=0; j--) {
                if((nums[i] % nums[j]) == 0) {
                    count[i] = Math.max(count[i], count[j]+1);
                }
            }
            if(count[maxCountIndex] < count[i]) {
                maxCountIndex = i;
            }
        }

        int countVal = count[maxCountIndex];
        int val = nums[maxCountIndex];

        for(int i= maxCountIndex; i >= 0; i--) {
            if ((countVal == count[i]) && (val % nums[i] == 0)) {
                result.add(nums[i]);
                val = nums[i];
                countVal--;
            }
        }
        return result;
    }
}
