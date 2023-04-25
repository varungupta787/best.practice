package leetcode;

/*  1047. Remove All Adjacent Duplicates In String  */

/*  https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/ */

/*
*
* You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.



Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
*
* */

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<String> stk = new Stack<>();
        String str = "";
        for(int i=0; i<s.length(); i++) {
            str = s.substring(i, i+1);
            if(stk.isEmpty()) {
                stk.push(str);
            } else {
                if(stk.peek().equals(str)) {
                    stk.pop();
                } else {
                    stk.push(str);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
