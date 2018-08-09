//Author: Tushar Jaiswal
//Creation Date: 08/08/2018

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

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for(String str : dict)
        { trie.insert(str); }
        
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
        
        String prefix = "";
        for(String str : words)
        { 
            sb.append(prefix);
            prefix = " ";
            sb.append(trie.search(str));
            
        }
        return sb.toString();
    }
}

class Trie {

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
            if(!curr.children.containsKey(c))
            { curr.children.put(c, new TrieNode()); }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    /** Returns if the root of the word is in the trie. */
    public String search(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray())
        {
            if(curr.isWord) 
            { return sb.toString(); }
            if(!curr.children.containsKey(c))
            { return word; }
            curr = curr.children.get(c);
            sb.append(c);
        }
        return word;
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public boolean isWord = false;
}