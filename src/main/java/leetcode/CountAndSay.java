package leetcode;

/*  38. Count and Say   */

/*  https://leetcode.com/problems/count-and-say/description/    */

/*
*
* The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.



Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
*
* */



public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        int i=3;
        String result = "11";
        while(i<=n) {
            result = getValue(result);
            i++;
        }
        return result;
    }

    private String getValue(String n) {
        char[] arr = n.toCharArray();
        int c = 1;
        int len = arr.length;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<len-1; i++) {
            if(arr[i] == arr[i+1]) {
                c++;
                if(i == len-2) {
                    sb.append(c).append(arr[i+1]);
                }
            } else {
                sb.append(c).append(arr[i]);
                c = 1;
                if(i == len-2) {
                    sb.append(c).append(arr[i+1]);
                }
            }
        }
        return sb.toString();
    }
}
