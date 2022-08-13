package leetcode;

/*  692. Top K Frequent Words   */

/*  https://leetcode.com/problems/top-k-frequent-words/ */

/*
*
* Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.



Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
*
* */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String str : words) {
            if(freq.get(str) == null) {
                freq.put(str, 1);
                res.add(str);
            } else {
                freq.put(str, freq.get(str)+1);
            }
        }


        Collections.sort(res, (a, b)-> {
            int f1 = freq.get(a);
            int f2 = freq.get(b);
            if(f1 == f2)  {
                return a.compareTo(b);
            } else {
                return f2-f1;
            }
        });


        return res.subList(0, k);
    }
}
