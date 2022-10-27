package leetcode;

/*  916. Word Subsets   */

/*  https://leetcode.com/problems/word-subsets/description/     */

/*
*
* You are given two string arrays words1 and words2.

A string b is a subset of string a if every letter in b occurs in a including multiplicity.

For example, "wrr" is a subset of "warrior" but is not a subset of "world".
A string a from words1 is universal if for every string b in words2, b is a subset of a.

Return an array of all the universal strings in words1. You may return the answer in any order.



Example 1:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
Example 2:

Input: words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["l","e"]
Output: ["apple","google","leetcode"]
*
* */


import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] freq = new int[26];
        for(String str : words2) {
            int[] arr = getFreq(str);
            for(int i=0; i<26; i++) {
                freq[i] = Math.max(freq[i], arr[i]);
            }
        }

        for(String str : words1) {
            int[] arr = getFreq(str);
            boolean status = true;
            for(int i=0; i<26; i++) {
                if(arr[i] < freq[i]) {
                    status = false;
                    break;
                }
            }
            if(status) {
                result.add(str);
            } else {
                status = true;
            }
        }
        return result;
    }

    private int[] getFreq(String input) {
        int[] arr = new int[26];
        for(char ch : input.toCharArray()) {
            arr[ch - 'a']++;
        }
        return arr ;
    }
}
