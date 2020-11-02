package leetcode;

import java.util.HashSet;

/*  3. Longest Substring Without Repeating Characters   */

/*  https://leetcode.com/problems/longest-substring-without-repeating-characters/   */

/*
*
* Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*
* */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> unique = new HashSet<>();
        int head = 0;
        int tail = 1;
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        unique.add(s.charAt(0));
        int max = 1;
        while (tail < len) {
            char c = s.charAt(tail);
            if (unique.contains(c)) {
                while (unique.contains(c)) {
                    unique.remove(s.charAt(head++));
                }
            }
            unique.add(c);
            max = (max>=unique.size())? max: unique.size();
            tail++;
        }
        return max;
    }
}
