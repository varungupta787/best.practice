package leetcode;

import java.util.*;

/*  127. Word Ladder    */

/*  https://leetcode.com/problems/word-ladder/  */

/*
*
* Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*
* */

public class WordLadder {

    public int ladderLength(String beginWord,
                            String endWord,
                            List<String> wordList) {
        if(beginWord.isEmpty() || endWord.isEmpty() ||
                wordList.size() == 0) {
            return 0;
        }

        int count = 0;
        Queue<String> queue= new LinkedList<>();
        queue.add(beginWord);
        count++;

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size > 0) {
                String curr = queue.remove();
                Iterator itr = wordList.iterator();
                while(itr.hasNext()) {
                    String str = (String)itr.next();
                    if(isAdjacent(curr, str)) {
                        queue.add(str);
                        itr.remove();
                        if(str.equals(endWord)) {
                            return count;
                        }
                    }
                }
                size--;
            }
        }
        return 0;
    }

    private boolean isAdjacent(String str1, String str2) {
        int count=0;
        char[] chArr1 = str1.toCharArray();
        char[] chArr2 = str2.toCharArray();
        for(int i=0; i< chArr1.length; i++) {
            if(chArr1[i] != chArr2[i]) {
                count++;
            }
            if(count > 1) {
                return false;
            }
        }
        return count == 1;
    }


    static class Pair {
        private int len;
        private String str;
        public Pair(String str, int len) {
            this.len = len;
            this.str = str;
        }
    }
}
