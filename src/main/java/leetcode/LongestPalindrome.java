package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*  409. Longest Palindrome */

/*  https://leetcode.com/problems/longest-palindrome/   */

/*
*
* Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*
* */

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() < 2) {
            return s.length();
        }
        HashMap<Character, Integer> data = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(data.get(ch) == null) {
                data.put(ch, 1);
            } else {
                data.put(ch, data.get(ch)+1);
            }
        }
        int out = 0;
        Set<Character> set = data.keySet();
        Iterator<Character> itr = set.iterator();
        while(itr.hasNext()) {
            int val = data.get(itr.next());
            out += (val%2 == 0) ? val : val-1;
        }
        if(out < s.length()) {
            out++;
        }
        return out;
    }
}