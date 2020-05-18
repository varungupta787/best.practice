package leetcode;

/*  567. Permutation in String  */

/*  https://leetcode.com/problems/permutation-in-string/    */

/*
* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False


Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*
* */

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if(s1== null || s1.isEmpty() || s2== null || s2.isEmpty()) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();

        if(len1 > len2) {
            return false;
        }

        int[] map = new int[26];

        for(int i=0; i<len1; i++) {
            map[s1.charAt(i) - 'a']--;
            map[s2.charAt(i) - 'a']++;
        }

        if(checkForData(map)) {
            return true;
        }

        for(int i=len1; i<len2; i++) {
            map[s2.charAt(i-len1) - 'a']--;
            map[s2.charAt(i) - 'a']++;
            if(checkForData(map)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForData(int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }
}
