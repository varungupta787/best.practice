package leetcode;

/*  2272. Substring With Largest Variance   */

/*  https://leetcode.com/problems/substring-with-largest-variance/  */

/*
*
* The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.

Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "aababbb"
Output: 3
Explanation:
All possible variances along with their respective substrings are listed below:
- Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
- Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
- Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
- Variance 3 for substring "babbb".
Since the largest possible variance is 3, we return it.
Example 2:

Input: s = "abcde"
Output: 0
Explanation:
No letter occurs more than once in s, so the variance of every substring is 0.
*
* */

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        if(s == null || s.length() <2) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        char[] arr = s.toCharArray();
        int c1= 0, c2 = 0;
        int[] freq = new int[26];
        for(char ch : arr) {
            freq[ch-'a']++;
        }
        for(char i='a'; i<='z'; i++) {
            for(char j='a'; j<='z'; j++) {
                if(i != j && freq[i-'a'] > 0 && freq[j-'a'] > 0 ) {
                    int k=freq[i-'a'];
                    k++;
                    c1 = c2 = 0;
                    for(char ch : arr) {
                        if(ch == i) {
                            c1++;
                            k--;
                        }
                        if(ch == j) {
                            c2++;
                        }

                        if(c1 > 0){
                            res = Math.max(res, c2-c1);
                        }

                        if( c1 > c2 && k>1) {
                            c1 = c2 = 0;
                        }
                    }
                }
            }
        }
        return res;
    }
}
