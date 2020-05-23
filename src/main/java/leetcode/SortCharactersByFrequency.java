package leetcode;

import java.util.*;

/*  451. Sort Characters By Frequency   */

/*  https://leetcode.com/problems/sort-characters-by-frequency/     */

/*
*
* Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*
* */


public class SortCharactersByFrequency {

     public String frequencySort(String s) {

        if(s == null || s.length() == 0) return s;

        int[] count = new int[256];
        for(char c : s.toCharArray()){
            count[c]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);
        for(int i = 0; i < 256; i++){
            pq.offer((char)i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            for(int i = 0; i < count[c]; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
