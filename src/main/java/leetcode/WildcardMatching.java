package leetcode;

/*  44. Wildcard Matching   */

/*  https://leetcode.com/problems/wildcard-matching/    */

/*
*
* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
*
* */


public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        int size1 = s.length();
        int size2 = p.length();
        boolean[][] mat = new boolean[size1 + 1][size2 + 1];

        mat[0][0] = true;

        for (int j = 1; j <= size2; j++) {
            if (p.charAt(j - 1) == '*') {
                mat[0][j] = mat[0][j - 1];
            }
        }

        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '?') {
                    mat[i][j] = mat[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    mat[i][j] = mat[i][j - 1] || mat[i - 1][j];
                }
            }
        }
        return mat[size1][size2];
    }
}
