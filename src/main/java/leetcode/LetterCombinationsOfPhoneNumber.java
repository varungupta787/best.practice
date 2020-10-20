package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  17. Letter Combinations of a Phone Number   */

/*  https://leetcode.com/problems/letter-combinations-of-a-phone-number/    */

/*
*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.





Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*
* */


public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits == null || digits.isEmpty()) {
            return res;
        }
        char[] input = digits.toCharArray();

        int i=0;
        while(i< input.length) {
            ArrayList<String> temp = new ArrayList<>();
            char[] arr = getNumberString(input[i]).toCharArray();
            for(int j=0; j<arr.length; j++) {
                String ss = Character.toString(arr[j]);
                if(res.isEmpty()) {
                    temp.add(ss);
                } else {
                    for(int k=0; k<res.size(); k++) {
                        temp.add(res.get(k) + ss);
                    }
                }
            }
            res = temp;
            i++;
        }
        return res;
    }

    private String getNumberString(int num) {
        switch(num) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default : return "";
        }
    }
}
