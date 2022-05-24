package leetcode;

/*  https://leetcode.com/problems/implement-trie-prefix-tree/   */

/*  208. Implement Trie (Prefix Tree)   */

/*
*
* A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
*
* */

public class ImplementTrie {
    private Node root;
    public ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        char[] arr = word.toCharArray();
        Node node = root;
        for(char ch : arr) {
            Node[] childList = node.getChildList();
            Node childNode = childList[ch - 'a'];
            if(childNode == null) {
                childNode = new Node();
                childList[ch - 'a'] = childNode;
            }
            node = childNode;
        }
        node.setLeafNode();
    }

    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Node node = root;
        for(char ch : arr) {
            Node[] childList = node.getChildList();
            Node childNode = childList[ch - 'a'];
            if(childNode == null) {
                return false;
            } else {
                node = childNode;
            }
        }
        return node.isLeafNode();
    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Node node = root;
        for(char ch : arr) {
            Node[] childList = node.getChildList();
            Node childNode = childList[ch - 'a'];
            if(childNode == null) {
                return false;
            } else {
                node = childNode;
            }
        }
        return true;
    }

    static class Node {
        Node[] list;
        boolean isLeaf;
        public Node() {
            list = new Node[26];
        }

        public void setLeafNode() {
            isLeaf = true;
        }

        public boolean isLeafNode() {
            return isLeaf;
        }

        public Node[] getChildList() {
            return list;
        }
    }
}