package leetcode;

import java.util.Random;

/*  470. Implement Rand10() Using Rand7()   */

/*  https://leetcode.com/problems/implement-rand10-using-rand7/ */

/*
*
* Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().



Example 1:

Input: 1
Output: [7]
Example 2:

Input: 2
Output: [8,4]
Example 3:

Input: 3
Output: [8,1,10]


Note:

rand7 is predefined.
Each testcase has one argument: n, the number of times that rand10 is called.


Follow up:

What is the expected value for the number of calls to rand7() function?
Could you minimize the number of calls to rand7()?
*
* */

public class ImplementRand10UsingRand7 {
    public int rand10() {
        int v1 = rand7();
        int v2 = rand7();
        while (v1 > 5) {
            v1 = rand7();
        }
        while (v2 == 7) {
            v2 = rand7();
        }

        return ((v2 <= 3) ? v1 : v1 + 5);
    }

    private int rand7() {
        return new Random().nextInt(7);
    }
}
