package leetcode;

/*  949. Largest Time for Given Digits  */

/*  https://leetcode.com/problems/largest-time-for-given-digits/    */

/*
*
* Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.



Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
*
* */

import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] A) {
        List<String> permutations = permutations(A);
        String res = "";
        for (String p : permutations) {
            String HH = p.substring(0, 2);
            String MM = p.substring(2);
            if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
                res = HH + ":" + MM;
        }

        return res;
    }

    private List<String> permutations(int[] A) {
        String s = "";
        for (int a : A)
            s += a;
        List<String> list = new ArrayList();
        permutations(s, "", list);
        return list;
    }

    private void permutations(String s, String sofar, List<String> list) {
        if (s.isEmpty()) list.add(sofar);

        for (int i = 0; i < s.length(); i++) {
            permutations(s.substring(0, i) + s.substring(i + 1), sofar + s.charAt(i), list);
        }
    }
}
