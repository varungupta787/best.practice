package leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*  347. Top K Frequent Elements    */

/*  https://leetcode.com/problems/top-k-frequent-elements/  */

/*
*
* Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*
* */


public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<> ();


        for(int val : nums) {
            if(map.get(val) == null) {
                map.put(val, 1);
            } else {
                map.put(val, map.get(val)+1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> {
            return a.getValue()  - b.getValue();
        });

        int i = 0;
        int[] out = new int[k];
        for(Map.Entry<Integer, Integer> entry : entrySet) {
            queue.add(new Pair<>(entry.getKey(), entry.getValue()));
            if(queue.size() > k) {
                queue.remove();
            }
        }


        while(!queue.isEmpty()) {
            out[i] = queue.poll().getKey();
            i++;
        }
        return out;
    }
}
