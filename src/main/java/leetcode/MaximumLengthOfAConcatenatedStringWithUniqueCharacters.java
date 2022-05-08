package leetcode;

/*  1239. Maximum Length of a Concatenated String with Unique Characters    */

/*  https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/   */

/*
*
* You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.

*
* */

import java.util.HashSet;
import java.util.List;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        return maxLengthUtil(arr, "", 0);
    }

    private int maxLengthUtil(List<String> arr, String str, int i) {
        if(i >= arr.size()) {
            return str.length();
        }

        int res = 0;
        if(isUnique(str+arr.get(i))) {
            res = maxLengthUtil(arr, str+arr.get(i), i+1);
        }
        res = Math.max(res, maxLengthUtil(arr, str, i+1));
        return res;
    }

    private boolean isUnique(String str) {
        char[] arr = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for(char ch: arr) {
            if(set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
