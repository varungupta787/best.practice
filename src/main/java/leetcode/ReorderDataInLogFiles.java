package leetcode;

/*  937. Reorder Data in Log Files  */

/*  https://leetcode.com/problems/reorder-data-in-log-files/    */

/*
*
* You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.



Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
*
* */


import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new MySorting());
        return logs;
    }

    class MySorting implements Comparator<String> {

        @Override
        public int compare(String a, String b) {

            String[] s1 = a.split(" ", 2);
            String[] s2 = b.split(" ", 2);

            char ch1 = s1[1].charAt(0);
            char ch2 = s2[1].charAt(0);

            if(('0' <=ch1 && ch1 <= '9') &&
                    ('0' <=ch2 && ch2 <= '9')) {
                return 0;
            } else if(('a' <=ch1 && ch1 <= 'z') &&
                    ('a' <=ch2 && ch2 <= 'z')) {
                if(s1[1].equals(s2[1])) {
                    return s1[0].compareTo(s2[0]);
                }
                return s1[1].compareTo(s2[1]);
            } else {
                return ch2-ch1;
            }
        }
    }
}
