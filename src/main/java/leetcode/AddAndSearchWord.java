package leetcode;

/*  211. Add and Search Word - Data structure design    */

/*  https://leetcode.com/problems/add-and-search-word-data-structure-design/    */

/*
*
* Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*
* */

public class AddAndSearchWord {

    Trie root;
    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(root == null || word == null || word.isEmpty()) {
            return;
        }

        Trie node = root;
        for(char ch : word.toCharArray()) {
            int i = ch - 'a';
            if(node.child[i] == null) {
                node.child[i] = new Trie();
            }
            node = node.child[i];
        }
        node.leaf = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(root == null || word == null || word.isEmpty()) {
            return false;
        }
        return searchUtil(word, 0, root);
    }

    public boolean searchUtil(String word, int index, Trie node) {
        if(node == null || index > word.length()) {
            return false;
        }

        if (word.length() == index) {
            return node.leaf;
        }
        char ch = word.charAt(index);

        if(ch == '.') {
            for(int i=0; i< 26; i++) {
                if(searchUtil(word, index+1, node.child[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int i = ch  - 'a';
            if(node.child[i] == null) {
                return false;
            } else {
                return searchUtil(word, index+1, node.child[i]);
            }
        }
    }

    static public class Trie {
        public boolean leaf;
        public Trie[] child;
        public Trie() {
            child = new Trie[26];
        }
    }
}