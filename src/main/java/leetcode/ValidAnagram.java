package leetcode;

/*  https://leetcode.com/problems/valid-anagram/description/    */

/*  242. Valid Anagram  */

/*
*
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
*
* */


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {

            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

        for(int val : freq) {
            if(val != 0) {
                return false;
            }
        }

        return true;
    }
}
