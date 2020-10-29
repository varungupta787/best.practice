package leetcode;

import java.util.*;

/*  49. Group Anagrams  */

/*  https://leetcode.com/problems/group-anagrams/   */

/*
*
*
*Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*
**/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String ss = Arrays.toString(chArr);
            if(map.get(ss) == null) {
                ArrayList<String> list = new ArrayList<>();
                map.put(ss, list);
            }
            map.get(ss).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
