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

public class MapSum {
    TrieNode root; 
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();        
    }
    
    public void Insert(string key, int val) {
        TrieNode curr = root;
        foreach(char c in key)
        {
            if(!curr.children.ContainsKey(c))
            { curr.children.Add(c, new TrieNode()); }
            curr = curr.children[c];
        }
        curr.val = val;
    }
    
    public int Sum(string prefix) {
        TrieNode curr = root;
        foreach(char c in prefix)
        {
            if(!curr.children.ContainsKey(c))
            { return 0; }
            curr = curr.children[c];
        }
        return GetSumAtNode(curr);
    }
    
    public int GetSumAtNode(TrieNode curr)
    {
        int sum = curr.val;
        foreach(TrieNode child in curr.children.Values)
        { sum += GetSumAtNode(child); }
        return sum;
    }
}

public class TrieNode {
    public Dictionary<char, TrieNode> children = new Dictionary<char, TrieNode>();
    public int val = 0;
}
    

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.Insert(key,val);
 * int param_2 = obj.Sum(prefix);
 */