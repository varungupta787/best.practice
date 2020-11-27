package leetcode;

import java.util.Stack;

/*  394. Decode String  */

/*  https://leetcode.com/problems/decode-string/    */

/*
*
* Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].



Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
*
* */

public class DecodeString {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();

        Stack<Character> stk = new Stack<>();

        for(char ch : arr) {
            if(ch == ']') {
                String temp = "";
                while(stk.peek() != '[')  {
                    char val = stk.pop();
                    temp = val + temp;
                }
                stk.pop();
                String num = "";
                while(!stk.isEmpty() && stk.peek() >= '0' && stk.peek() <= '9') {
                    char val = stk.pop();
                    num = val + num;
                }
                int number = Integer.parseInt(num);
                String newtemp = "";
                while(number-- > 0) {
                    newtemp += temp;
                }
                for(char val1 : newtemp.toCharArray()) {
                    stk.push(val1);
                }
            } else {
                stk.push(ch);
            }
        }
        String res = "";
        while(!stk.isEmpty()) {
            res = stk.pop() + res;
        }
        return res;
    }
}
