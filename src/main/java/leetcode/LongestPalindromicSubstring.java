package leetcode;

/*  5. Longest Palindromic Substring    */

/*  https://leetcode.com/problems/longest-palindromic-substring/    */

/*
*
* Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
*
* */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0; i< s.length(); i++) {
            String s1 = getPalindrome(s, i, i);
            String s2 = getPalindrome(s, i-1, i);
            if(s1.length() > res.length()) {
                res = s1;
            }
            if(s2.length() > res.length()) {
                res = s2;
            }
        }
        return res;
    }

    private String getPalindrome(String s, int j, int i) {
        if(j<0 || i > s.length()) {
            return "";
        }
        while( j >= 0 && i < s.length() &&
                s.charAt(j) == s.charAt(i)) {
            j--;
            i++;
        }

        if(j+1 == i) {
            return "";
        }
        return s.substring(j+1, i);
    }
}
