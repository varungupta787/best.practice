package leetcode;

/*  125. Valid Palindrome   */

/*  https://leetcode.com/problems/valid-palindrome/ */

/*
*
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false


Constraints:

s consists only of printable ASCII characters.
*
* */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }

        int start = 0, end = s.length() - 1;

        while (start <= end) {
            char ch1 = s.charAt(start);
            char ch2 = s.charAt(end);
            if (!(Character.isLetterOrDigit(ch1))) {
                start++;
            } else if (!(Character.isLetterOrDigit(ch2))) {
                end--;
            } else if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
}