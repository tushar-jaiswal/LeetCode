//Author: Tushar Jaiswal
//Creation Date: 08/10/2018

/*Design a data structure that supports the following two operations:
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
Note: You may assume that all words are consist of lowercase letters a-z.*/

public class WordDictionary {    
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void AddWord(string word) {
        TrieNode curr = root;
        foreach(char c in word)
        {
            if(!curr.children.ContainsKey(c))
            { curr.children.Add(c, new TrieNode()); }
            curr = curr.children[c];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public bool Search(string word) {
        return SearchChildren(word, 0, root);
    }
    
    public bool SearchChildren(string word, int position, TrieNode curr)
    {
        for(int i = position; i < word.Length; i++)
        {
            if(word[i] == '.')
            {
                foreach(TrieNode child in curr.children.Values)
                {
                    if(SearchChildren(word, i + 1, child))
                    { return true; }
                }
                return false;
            }
            else if(!curr.children.ContainsKey(word[i]))
            { return false; }
            else
            { curr = curr.children[word[i]]; }
        }
        if(curr.isWord)
        { return true; }
        else
        { return false; }
    }
}

public class TrieNode {
    public Dictionary<char, TrieNode> children = new Dictionary<char, TrieNode>();
    public bool isWord = false; 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */