package leetcode;

/*   76. Minimum Window Substring   */

/*   https://leetcode.com/problems/minimum-window-substring/   */

/*
*
* Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
*
* */

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) {
            return "";
        }

        int n = s.length(), m = t.length(), count=0, start = 0;
        String res = "";
        char[] ch1 = s.toCharArray(), ch2 = t.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<m; i++) {
            if(map2.get(ch2[i]) == null) {
                map2.put(ch2[i], 1);
            } else {
                map2.put(ch2[i], map2.get(ch2[i])+1);
            }
        }

        for(int i=0; i<n; i++) {
            if(map2.get(ch1[i]) != null) {
                if(map1.get(ch1[i]) == null) {
                    map1.put(ch1[i], 1);
                }  else {
                    map1.put(ch1[i], map1.get(ch1[i])+1);
                }
                if(map1.get(ch1[i]) != null) {
                    int c2 = map2.get(ch1[i]);
                    int c1 = map1.get(ch1[i]);

                    if(c1 <= c2) {
                        count++;
                    }
                    if(count == m && (res.isEmpty() || res.length() > (i-start+1))) {
                        res = s.substring(start, i+1);
                    }

                    while(count == m) {
                        if(map2.get(ch1[start]) != null) {
                            c2 = map2.get(ch1[start]);
                            c1 = map1.get(ch1[start]);
                            c1--;
                            if(c1 < c2) {
                                count--;
                            }
                            if(c1 == 0) {
                                map1.put(ch1[start], null);
                            } else {
                                map1.put(ch1[start], c1);
                            }
                        }
                        start++;
                        if(count == m && (res.isEmpty() || res.length() > (i-start+1))) {
                            res = s.substring(start, i+1);
                        }
                    }
                }
            }
        }
        return res;
    }
}
