package leetcode;

import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        int count = 0, res = 0;
        map.put(0, -1);

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] == 1) count++;
            else count--;
            map.putIfAbsent(count, i);
            res = Math.max(res, i - map.get(count));
        }
        return res;
    }
}