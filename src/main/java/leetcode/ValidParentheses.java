package leetcode;

import java.util.Stack;

/*  20. Valid Parentheses   */

/*  https://leetcode.com/problems/valid-parentheses/    */

/*
*
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true
*
* */

public class ValidParentheses {
    public boolean isValid(String s) {

        char[] chArr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        for(char ch : chArr) {
            if(ch == '{' || ch == '[' || ch == '(') {
                stk.push(ch);
            } else {
                if(stk.isEmpty()) {
                    return false;
                }
                char val = stk.pop();
                if(val == '{' && ch != '}' ||
                        val == '(' && ch != ')' ||
                        val == '[' && ch != ']') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
