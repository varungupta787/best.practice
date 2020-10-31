package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*  131. Palindrome Partitioning    */

/*  https://leetcode.com/problems/palindrome-partitioning/  */

/*
*
* Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*
* */

public class PalindromePartitioning {
    Map<String, List<List<String>>> map = new HashMap();

    public List<List<String>> partition(String s) {
        if (map.containsKey(s))
            return map.get(s);
        List<List<String>> result = new LinkedList<>();
        if (isPalindrome(s)) {
            List<String> val = new LinkedList<>();
            val.add(s);
            result.add(val);
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (isPalindrome(left)) {
                for (List<String> ss : partition(s.substring(i))) {
                    List<String> val = new LinkedList<>();
                    val.add(left);
                    val.addAll(ss);
                    result.add(val);
                }
            }
        }
        map.put(s, result);
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        char[] chArr = s.toCharArray();
        int i = 0, j = chArr.length - 1;
        while (i < j) {
            if (chArr[i] != chArr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}