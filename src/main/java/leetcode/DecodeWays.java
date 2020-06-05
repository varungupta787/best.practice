package leetcode;

/*  91. Decode Ways */

/*  https://leetcode.com/problems/decode-ways/  */

/*
*
* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*
* */

public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] data = new int[len + 1];
        data[0] = 1;
        data[1] = 1;

        for (int i = 1; i < len; i++) {
            int val1 = s.charAt(i - 1) - '0';
            int val2 = s.charAt(i) - '0';
            if (val2 > 0) {
                data[i + 1] = data[i];
            }

            if (val1 == 1 || (val1 == 2 && (val2 >= 0 && val2 <= 6))) {
                data[i + 1] += data[i - 1];
            }
        }
        return data[len];
    }
}
