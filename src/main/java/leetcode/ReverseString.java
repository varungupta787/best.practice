package leetcode;

/*  344. Reverse String */

/*  https://leetcode.com/problems/reverse-string/   */

/*
*
* Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*
*  */

public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length;

        for (int i = 0; i < len / 2; i++) {
            char val = s[len - i - 1];
            s[len - i - 1] = s[i];
            s[i] = val;
        }
    }
}
