package leetcode;

/*  301. Remove Invalid Parentheses */

/*  https://leetcode.com/problems/remove-invalid-parentheses/description/   */

/*
*
* Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.



Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]
Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]
Example 3:

Input: s = ")("
Output: [""]
*
* */

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        removeInvalidParenthesesSolve(s, 0, 0, result, '(',')');
        return result;
    }
    private void removeInvalidParenthesesSolve(String s, int left,
                                               int right, List<String> result,
                                               char open, char close) {
        int count=0;
        while(right<s.length()) {
            if(s.charAt(right) == open) {
                count++;
            }
            if(s.charAt(right) == close) {
                count--;
            }
            if(count >=0) {
                right++;
                continue;
            }
            for(int i=left; i<=right; i++) {
                if((s.charAt(i) == close &&
                        (i==0 || i>0 && s.charAt(i-1) != close)
                )) {
                    String ss = s.substring(0, left) +
                            s.substring(left+1);
                    removeInvalidParenthesesSolve(ss, left, right,
                            result, open , close);
                }
                left++;
            }
            return;
        }
        String reverse = new StringBuffer(s).reverse().toString();
        if(open == '(')
            removeInvalidParenthesesSolve(reverse, 0, 0, result, close, open);
        else
            result.add(reverse);
    }
}
