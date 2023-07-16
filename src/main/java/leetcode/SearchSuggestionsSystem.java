package leetcode;

/*  https://leetcode.com/problems/search-suggestions-system/description/    */

/*  1268. Search Suggestions System */

/*
*
* You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.



Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.
*
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products,
                                                String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int n = searchWord.length(), i=1;
        while(i<=n) {
            List<String> temp = new ArrayList<>();
            String currSearch = searchWord.substring(0,i);
            int index = 0;
            while(index < products.length && temp.size()<3) {
                if(products[index].startsWith(currSearch)) {
                    temp.add(products[index]);
                }
                index++;
            }

            result.add(temp);

            i++;
        }
        return result;
    }
}
