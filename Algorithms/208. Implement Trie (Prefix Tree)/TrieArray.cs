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
    public void Insert(string word) {
        TrieNode curr = root;
        foreach(char c in word)
        {
            if(curr.children[c - 'a'] == null)
            { curr.children[c - 'a'] =  new TrieNode(); }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        TrieNode curr = root;
        foreach(char c in word)
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
    public bool StartsWith(string prefix) {
        TrieNode curr = root;
        foreach(char c in prefix)
        {
            if(curr.children[c - 'a'] == null)
            { return false; }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

public class TrieNode{
    public const int N = 26;
    public TrieNode[] children = new TrieNode[N];
    public bool isWord = false;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */