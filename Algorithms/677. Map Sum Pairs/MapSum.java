//Author: Tushar Jaiswal
//Creation Date: 08/08/2018

/*Implement a MapSum class with insert, and sum methods.
For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5*/

class MapSum {
    TrieNode root; 

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();  
    }
    
    public void insert(String key, int val) {
        TrieNode curr = root;
        for(char c : key.toCharArray())
        {
            if(!curr.children.containsKey(c))
            { curr.children.put(c, new TrieNode()); }
            curr = curr.children.get(c);
        }
        curr.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(!curr.children.containsKey(c))
            { return 0; }
            curr = curr.children.get(c);
        }
        return getSumAtNode(curr);
    }
    
    public int getSumAtNode(TrieNode curr)
    {
        int sum = curr.val;
        for(TrieNode child : curr.children.values())
        { sum += getSumAtNode(child); }
        return sum;
    }
}

class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public int val = 0;
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */