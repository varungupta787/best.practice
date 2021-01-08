package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

/*  767. Reorganize String  */

/*  https://leetcode.com/problems/reorganize-string/    */

/*
*
* Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
*
* */

public class ReorganizeString {
    public String reorganizeString(String S) {
        StringBuffer sb = new StringBuffer();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : S.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Character> queue =
                new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        while(queue.size() > 1) {
            char ch1 = queue.remove();
            char ch2 = queue.remove();

            sb.append(ch1);
            sb.append(ch2);

            if(map.get(ch1) > 1) {
                map.put(ch1, map.get(ch1)-1);
                queue.add(ch1);
            }
            if(map.get(ch2) > 1) {
                map.put(ch2, map.get(ch2)-1);
                queue.add(ch2);
            }
        }
        if(!queue.isEmpty()) {
            char ch = queue.remove();
            if(map.get(ch) > 1) {
                return "";
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
