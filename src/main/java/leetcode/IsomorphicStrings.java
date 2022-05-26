package leetcode;

/*  https://leetcode.com/problems/isomorphic-strings/   */

/*  205. Isomorphic Strings */

/*
*
* Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
*
* */

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return check(s, t) && check(t, s);
    }

    public boolean check(String s, String t) {
        HashMap<Character, Character> sData = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for(int i=0; i< sArr.length; i++) {
            if(sData.get(sArr[i]) == null) {
                sData.put(sArr[i], tArr[i]);
            } else {
                if(sData.get(sArr[i]) != tArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
