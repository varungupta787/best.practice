package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  22. Generate Parentheses    */

/*  https://leetcode.com/problems/generate-parentheses/ */

/*
*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
*
* */

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res =  new ArrayList<>();
        getParaentheses("", 0, n, res);
        return res;
    }

    private void getParaentheses(String val, int leftParan, int n, List<String> res){
        if(val.length() == 2*n) {
            res.add(val);
            return;
        }

        if(leftParan < n) {
            getParaentheses(val+"(", leftParan+1, n, res);
        }
        int rightParan = val.length()-leftParan;
        if(rightParan < leftParan) {
            getParaentheses(val+")", leftParan, n, res);
        }
    }
}
