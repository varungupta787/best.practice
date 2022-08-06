package leetcode;

/*  1525. Number of Good Ways to Split a String */

/*  https://leetcode.com/problems/number-of-good-ways-to-split-a-string/    */

/*
*
* You are given a string s.

A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.

Return the number of good splits you can make in s.



Example 1:

Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
Example 2:

Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").
*
* */


import java.util.HashSet;

public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        int res = 0;
        HashSet<Character> unique1 = new HashSet<>();
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++) {
            unique1.add(arr[i]);
            left[i] = unique1.size();
        }
        unique1.clear();
        for(int i=arr.length-1; i>=0; i--) {
            unique1.add(arr[i]);
            right[i] = unique1.size();
        }
        for(int i=0; i<arr.length-1; i++) {
            if(left[i] == right[i+1]) {
                res++;
            }
        }
        return res;
    }
}
