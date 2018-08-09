//Author: Tushar Jaiswal
//Creation Date: 08/08/2018

/*Implement a trie with insert, search, and startsWith methods.
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
All inputs are guaranteed to be non-empty strings.*/

public class Trie {

    private TrieNode root; 
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            { curr.children[c - 'a'] =  new TrieNode(); }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            { return false; }
            curr = curr.children[c - 'a'];
        }
        if(curr.isWord) 
        { return true; }
        else
        { return false; }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(curr.children[c - 'a'] == null)
            { return false; }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public static final int N = 26;
    public TrieNode[] children = new TrieNode[N];
    public boolean isWord = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */