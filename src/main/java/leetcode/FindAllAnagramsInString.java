package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  438. Find All Anagrams in a String  */

/*  https://leetcode.com/problems/find-all-anagrams-in-a-string/    */

/*
*
* Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*
*
* */


public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        int[] temp = new int[26];
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        int len1 = p.length(), len2 = s.length();

        if (len1 > len2) {
            return res;
        }

        for (int i = 0; i < len1; i++) {
            temp[(p.charAt(i) - 'a')]--;
            temp[(s.charAt(i) - 'a')]++;
        }

        if (checkForData(temp)) {
            res.add(0);
        }

        for (int i = len1; i < len2; i++) {
            temp[(s.charAt(i - len1) - 'a')]--;
            temp[(s.charAt(i) - 'a')]++;
            if (checkForData(temp)) {
                res.add(i - len1 + 1);
            }
        }
        return res;
    }

    private boolean checkForData(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}
