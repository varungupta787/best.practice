package leetcode;

/*  10. Regular Expression Matching     */

/*  https://leetcode.com/problems/regular-expression-matching/  */

/*
*
* Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
*
* */

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        int size1 = s.length();
        int size2 = p.length();
        boolean[][] mat = new boolean[size1+1][size2+1];

        mat[0][0] = true;

        for(int j=1; j<=size2; j++) {
            if(p.charAt(j-1) == '*') {
                mat[0][j] = mat[0][j-2];
            }
        }

        for(int i=1; i<=size1; i++) {
            for(int j=1; j<=size2; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) ||
                        p.charAt(j-1) == '.') {
                    mat[i][j] = mat[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    mat[i][j] = mat[i][j-2];
                    if(p.charAt(j-2) == '.' ||
                            p.charAt(j-2) == s.charAt(i-1)) {
                        mat[i][j] = mat[i][j] || mat[i-1][j];
                    }
                }
            }
        }
        return mat[size1][size2];
    }
}
