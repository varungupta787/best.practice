package leetcode;

/*  1032. Stream of Characters  */

/*  https://leetcode.com/problems/stream-of-characters/ */

/*
*
* Implement the StreamChecker class as follows:

StreamChecker(words): Constructor, init the data structure with the given words.
query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.


Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist


Note:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
Words will only consist of lowercase English letters.
Queries will only consist of lowercase English letters.
The number of queries is at most 40000
*
* */

public class StreamOfCharacters {
    private Trie root;
    private StringBuffer q;
    int maxLen = 0;
    public StreamOfCharacters(String[] words) {
        root = new Trie();
        q = new StringBuffer();
        for(int i=0; i< words.length; i++) {
            maxLen = Math.max(maxLen, words[i].length());
            addWord(words[i]);
        }
    }

    public boolean query(char letter) {
        if(root == null) {
            return false;
        }
        q.append(letter);
        String str = q.toString();

        Trie node = root;
        for(int j = str.length()-1; j>=0; j--) {
            int i  = str.charAt(j) - 'a';
            if(node.child[i] == null) {
                return false;
            }
            node = node.child[i];
            if(node.leaf) {
                return true;
            }
        }
        return false;
    }

    public void addWord(String word) {
        if(root == null || word == null || word.isEmpty()) {
            return;
        }

        Trie node = root;
        int len = word.length();
        for(int j=len-1; j>=0 ; j--) {
            int i = word.charAt(j) - 'a';
            if(node.child[i] == null) {
                node.child[i] = new Trie();
            }
            node = node.child[i];
        }
        node.leaf = true;
    }

    static public class Trie {
        public boolean leaf;
        public Trie[] child;
        public Trie() {
            child = new Trie[26];
        }
    }

}
