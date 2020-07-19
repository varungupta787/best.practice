package leetcode;

/*  67. Add Binary  */

/*  https://leetcode.com/problems/add-binary/   */

/*
*
* Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
*
* */

public class AddBinary {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        len1--;
        len2--;
        StringBuffer out = new StringBuffer();
        int c = 0;
        while(len1 >=0 || len2 >= 0) {
            int val = 0;
            if(len1 >= 0 && a.charAt(len1) == '1') {
                val++;
            }
            if(len2 >= 0 && b.charAt(len2) == '1') {
                val++;
            }
            val += c;
            c = val/2;
            out.append(val%2);
            len1--;
            len2--;
        }

        if(c == 1) {
            out.append(1);
        }

        return out.reverse().toString();
    }
}
