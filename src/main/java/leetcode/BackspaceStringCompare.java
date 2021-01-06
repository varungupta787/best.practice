package leetcode;

/*  844. Backspace String Compare   */

/*  https://leetcode.com/problems/backspace-string-compare/ */

/*
*
* 844. Backspace String Compare
Easy

2158

103

Add to List

Share
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
*
* */

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int len1 = S.length();
        int len2 = T.length();
        String res1 = "", res2 = "";
        int i=0;

        char ch;
        while(i<len1 || i<len2) {
            if(i< len1) {
                ch = S.charAt(i);
                if(ch == '#') {
                    if(!res1.isEmpty()) {
                        res1 = res1.substring(0, res1.length()-1);
                    }
                } else {
                    res1 = res1 + Character.toString(ch);
                }
            }
            if(i< len2) {
                ch = T.charAt(i);
                if(ch == '#') {
                    if(!res2.isEmpty()) {
                        res2 = res2.substring(0, res2.length()-1);
                    }
                } else {
                    res2 = res2 + Character.toString(ch);
                }
            }
            i++;
        }
        return res1.equalsIgnoreCase(res2);
    }
}
