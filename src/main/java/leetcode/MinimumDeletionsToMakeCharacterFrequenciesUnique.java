package leetcode;

/*  1647. Minimum Deletions to Make Character Frequencies Unique   */

/*  https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/   */

/*
*
* A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
*
* */


import java.util.HashSet;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {

        int[] ch = new int[26];
        char[] arr = s.toCharArray();
        for(char c : arr) {
            ch[c - 'a']++;
        }
        int delete = 0;
        HashSet<Integer> freq = new HashSet<>();
        for(int i: ch) {
            if(i > 0) {
                while(i > 0 && freq.contains(i)) {
                    i--;
                    delete++;
                }
                if(i > 0) {
                    freq.add(i);
                }
            }
        }
        return delete;
    }
}
