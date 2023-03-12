package leetcode;

/*  https://leetcode.com/problems/find-original-array-from-doubled-array/description/   */

/*  2007. Find Original Array From Doubled Array    */

/*
*
* An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.



Example 1:

Input: changed = [1,3,4,2,6,8]
Output: [1,3,4]
Explanation: One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].
Example 2:

Input: changed = [6,3,0,1]
Output: []
Explanation: changed is not a doubled array.
Example 3:

Input: changed = [1]
Output: []
Explanation: changed is not a doubled array.
*
* */


import java.util.Arrays;
import java.util.HashMap;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 != 0) {
            return new int[0];
        }
        int[] result = new int[n/2];
        Arrays.sort(changed);
        HashMap<Integer, Integer> map = new HashMap<>();
        addAllItems(changed, map);
        int j=0;
        for(int val : changed) {
            if(val == 0) {
                if(map.containsKey(val) && map.get(val) >= 2) {
                    result[j++] = val;
                    removeItem(val, map);
                    removeItem(2*val, map);
                }
            } else {
                if(map.containsKey(val) && map.containsKey(2*val)) {
                    result[j++] = val;
                    removeItem(val, map);
                    removeItem(2*val, map);
                }
            }
        }
        if(j < n/2) {
            return new int[0];
        }

        return result;
    }

    private void addAllItems(int[] arr, HashMap<Integer, Integer> map) {
        for(int value : arr) {
            if(map.containsKey(value))    {
                map.put(value, map.get(value)+1);
            } else{
                map.put(value, 1);
            }
        }
    }

    private void removeItem(int value, HashMap<Integer, Integer> map) {
        int c1 = map.get(value);
        if(c1-1 == 0)
            map.remove(value);
        else
            map.put(value, c1-1);
    }
}
