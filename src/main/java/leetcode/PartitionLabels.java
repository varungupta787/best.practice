package leetcode;

import java.util.ArrayList;
import java.util.List;

/*  763. Partition Labels   */

/*  https://leetcode.com/problems/partition-labels/ */

/*
*
* A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.



Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.


Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
*
* */

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIndex[S.charAt(i) - 'a'] = i;

        List<Integer> result = new ArrayList();
        int j = 0, subStrStart = 0;
        for (int i = 0; i < S.length(); i++) {
            j = Math.max(j, lastIndex[S.charAt(i) - 'a']);
            if (i == j) {
                result.add(i - subStrStart + 1);
                subStrStart = i + 1;
            }
        }

        return result;
    }
}
