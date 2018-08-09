//Author: Tushar Jaiswal
//Creation Date: 08/09/2018

/*In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000*/

public class Solution {
    public string ReplaceWords(IList<string> dict, string sentence) {
        Trie trie = new Trie();
        foreach(string str in dict)
        { trie.Insert(str); }
        
        StringBuilder sb = new StringBuilder();
        List<string> words = new List<string>(sentence.Split(new char[]{' '}, StringSplitOptions.RemoveEmptyEntries).ToList());
        
        string prefix = "";
        foreach(string str in words)
        { 
            sb.Append(prefix);
            prefix = " ";
            sb.Append(trie.Search(str));
            
        }
        return sb.ToString();
    }
}

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
            { curr.children[c - 'a'] = new TrieNode(); }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the root of the word is in the trie. */
    public string Search(string word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        foreach(char c in word)
        {
            if(curr.isWord) 
            { return sb.ToString(); }
            if(curr.children[c - 'a'] == null)
            { return word; }
            curr = curr.children[c - 'a'];
            sb.Append(c);
        }
        return word;
    }
}

public class TrieNode{
    public const int N = 26; 
    public TrieNode[] children = new TrieNode[N];
    public bool isWord = false;
}