package leetcode;

/*  151. Reverse Words in a String  */

/*  https://leetcode.com/problems/reverse-words-in-a-string/    */

/*
*
* Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.


Follow up:

For C programmers, try to solve it in-place in O(1) extra space
*
* */

public class ReverseWordsinString {
    public String reverseWords(String s) {
        if(s == null || s.isEmpty()) {
            return s;
        }
        String[] split = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i= split.length-1; i>= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1).toString();
    }
}
