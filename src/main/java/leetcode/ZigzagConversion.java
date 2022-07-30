package leetcode;

/*  6. Zigzag Conversion    */

/*  https://leetcode.com/problems/zigzag-conversion/    */

/*
*
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);


Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
*
* */


public class ZigzagConversion {
    public String convert(String s, int numRows) {
        int i=0, n=s.length(), index = 0, j=0;
        String[] sbArr = new String[numRows];
        for(j=0; j<numRows; j++)   {
            sbArr[j] = "";
        }
        while(i<n) {
            for(j=0; j<numRows && i<n; j++)   {
                sbArr[j] = sbArr[j]+(s.charAt(i));
                i++;
            }

            for(j=numRows-2; j>0  && i<n; j--)   {
                sbArr[j] = sbArr[j]+s.charAt(i);
                i++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String data : sbArr)   {
            sb.append(data);
        }
        return sb.toString();
    }
}
