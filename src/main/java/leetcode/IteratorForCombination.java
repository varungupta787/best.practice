package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*  1286. Iterator for Combination  */

/*  https://leetcode.com/problems/iterator-for-combination/ */

/*
*
* Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.


Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false


Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
*
* */

public class IteratorForCombination {
    List<String> data;
    int index;

    public IteratorForCombination(String characters, int combinationLength) {
        index = 0;
        data = new ArrayList<>();
        double val = Math.pow(2, characters.length());

        for(int i=1; i< val; i++) {
            StringBuffer sb = new StringBuffer();
            int j=0;
            while((1<<j) <= i) {
                if(((1<<j) & i) != 0) {
                    sb.append(Character.toString(characters.charAt(j)));
                }
                j++;
            }
            String s = sb.toString();
            if(s.length() == combinationLength) {
                data.add(s);
            }
        }
        Collections.sort(data);
    }

    public String next() {
        if(index < data.size()) {
            return data.get(index++);
        }
        return "";
    }

    public boolean hasNext() {
        return (index < data.size());
    }
}