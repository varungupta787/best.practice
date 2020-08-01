package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*  140. Word Break II  */

/*  https://leetcode.com/problems/word-break-ii/    */

/*
*
*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*
*/

public class WordBreakII {
    Map<String, List<String>> map = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s))
            return map.get(s);
        List<String> result = new LinkedList<>();
        if (wordDict.contains(s))
            result.add(s);
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left)) {
                for (String ss : wordBreak(s.substring(i), wordDict)) {
                    result.add(left+ " " + ss);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
