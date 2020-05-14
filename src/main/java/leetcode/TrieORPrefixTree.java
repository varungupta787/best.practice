package leetcode;

/*  208. Implement Trie (Prefix Tree)   */

/*  https://leetcode.com/problems/implement-trie-prefix-tree/   */

/*
* Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*
* */



public class TrieORPrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }


}

class Trie {
    public static final int MAX = 26;
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(root == null || word == null || word.isEmpty())
            return;
        Node curr = root;
        for(char val : word.toCharArray()) {
            Node temp = curr.getNodeList()[val - 'a'];
            if(temp == null) {
                temp = new Node(val);
                curr.getNodeList()[val - 'a'] = temp;
            }
            curr = temp;
        }
        curr.setLeafNode(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(root == null || word == null || word.isEmpty())
            return false;
        Node curr = root;
        for(char val : word.toCharArray()) {
            if(curr.getNodeList()[val - 'a'] != null) {
                curr = curr.getNodeList()[val - 'a'];
            } else {
                return false;
            }

        }
        return curr.isLeafNode();
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(root == null || prefix == null || prefix.isEmpty())
            return false;
        Node curr = root;
        for(char val : prefix.toCharArray()) {
            curr = curr.getNodeList()[val - 'a'];
            if(curr == null) {
                return false;
            }
        }

        return true;
    }

    static class Node {
        Node[] nodeList;
        char data;
        boolean isLeaf;

        Node() {
            nodeList = new Node[MAX];
            isLeaf= false;
        }

        Node(char val) {
            data = val;
            nodeList = new Node[MAX];
            isLeaf= false;
        }

        public boolean isLeafNode() {
            return isLeaf;
        }

        public void setLeafNode(boolean val) {
            isLeaf = val;
        }

        public void setData(char val) {
            data = val;
        }

        public char getData() {
            return data;
        }

        public Node[] getNodeList() {
            return nodeList;
        }
    }
}