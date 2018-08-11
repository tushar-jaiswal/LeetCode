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

class WordDictionary {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray())
        {
            if(!curr.children.containsKey(c))
            { curr.children.put(c, new TrieNode()); }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchChildren(word, 0, root);
    }
    
    public boolean searchChildren(String word, int position, TrieNode curr)
    {
        for(int i = position; i < word.length(); i++)
        {
            if(word.charAt(i) == '.')
            {
                for(TrieNode child : curr.children.values())
                {
                    if(searchChildren(word, i + 1, child))
                    { return true; }
                }
                return false;
            }
            else if(!curr.children.containsKey(word.charAt(i)))
            { return false; }
            else
            { curr = curr.children.get(word.charAt(i)); }
        }
        if(curr.isWord)
        { return true; }
        else
        { return false; }
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public boolean isWord = false; 
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */