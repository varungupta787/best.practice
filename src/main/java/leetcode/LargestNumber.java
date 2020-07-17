package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/*  179. Largest Number */

/*  https://leetcode.com/problems/largest-number/   */

/*
*
* Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*
* */

public class LargestNumber {
    public String largestNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        for(int i : nums) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list, (num1, num2) -> {
            if(num1 == num2) {
                return 0;
            }

            String str1 = num1 + num2;
            String str2 = num2 + num1;;
            return -1*(str1.compareTo(str2));
        });

        if(list.get(0).charAt(0) == '0') {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        for(String i : list) {
            sb.append(i);
        }


        return sb.toString();
    }
}
