//Author: Tushar Jaiswal
//Creation Date: 08/11/2018

/*Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before. The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first). If less than 3 hot sentences exist, then just return as many as you can. When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.

Your job is to implement the following functions:
The constructor function:
AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:
List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.

Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2]) 
The system have already tracked down the following sentences and their corresponding times: 
"i love you" : 5 times 
"island" : 3 times 
"ironman" : 2 times 
"i love leetcode" : 2 times 
Now, the user begins another search: 

Operation: input('i') 
Output: ["i love you", "island","i love leetcode"] 
Explanation: 
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored. 

Operation: input(' ') 
Output: ["i love you","i love leetcode"] 
Explanation: 
There are only two sentences that have prefix "i ". 

Operation: input('a') 
Output: [] 
Explanation: 
There are no sentences that have prefix "i a". 

Operation: input('#') 
Output: [] 
Explanation: 
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search. 

Note:
The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
Please use double-quote instead of single-quote when you write test cases even for a character input.
Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see herefor more details.*/

/*
This solution's 
Runtime complexity
	O(1) for getting autocomplete result
	O(len(sentence)) for adding a sentence either on initialization or when completing input with '#'

Space complexity
	O(nSumofLengthofAllSentences)
*/

using System;
using System.Collections.Generic;
using System.Text;


namespace Solution {
class Solution {
    static void Main(string[] args) {
        string[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
        int[] degree = {5, 3, 2, 2};
        AutocompleteSystem autocomplete = new AutocompleteSystem(sentences, degree);
        List<string> result = autocomplete.Input('i');
        result.ForEach(i => Console.WriteLine(i));
        result = autocomplete.Input(' ');
        result.ForEach(i => Console.WriteLine(i));
        result = autocomplete.Input('a');
        result.ForEach(i => Console.WriteLine(i));
        result = autocomplete.Input('#');
        result.ForEach(i => Console.WriteLine(i));
    }
}

class AutocompleteSystem {
    private TrieNode root;
    private TrieNode curr;
    private StringBuilder currSentence;
    
    public AutocompleteSystem(string[] sentences, int[] times) {
        root = new TrieNode();
        curr = root; 
        currSentence = new StringBuilder();
        
        for(int i = 0; i < sentences.Length; i++)
        { AddSentence(sentences[i], times[i]); }
    }

    public List<String> Input(char c) {
        List<string> result = new List<string>();
        if(c == '#')
        {
            string sentence = currSentence.ToString();
            AddSentence(sentence, 1);
            curr = root;
            currSentence.Clear();
        }
        else
        { currSentence.Append(c); }
        if(curr.children.ContainsKey(c))
        { 
            curr = curr.children[c]; 
            foreach(KeyValuePair<string, int> kvp in curr.topHotSentences)
            { result.Add(kvp.Key); }
        }
        return result; 
    }
    
    private void AddSentence(string sentence, int degree)
    {
        TrieNode node = root;
        foreach(char c in sentence)
        {
            if(!node.children.ContainsKey(c))
            { node.children.Add(c, new TrieNode()); }
            node = node.children[c];
        }
        if(node.degree == 0)
        { node.degree = degree; }
        else
        { node.degree += degree; }
        UpdateHotSentencesInNodes(sentence, node.degree);
    }
    
    private void UpdateHotSentencesInNodes(string sentence, int degree)
    {
        TrieNode node = root;
        foreach(char c in sentence)
        {
            node = node.children[c];
            node.topHotSentences.Add(new KeyValuePair<string, int>(sentence, degree));
            if(node.topHotSentences.Count > 3)
            { node.topHotSentences.Remove(node.topHotSentences.Max); }
        }
    }
}

class TrieNode {
    public Dictionary<char, TrieNode> children = new Dictionary<char, TrieNode>();
    public int degree = 0;
    public SortedSet<KeyValuePair<string, int>> topHotSentences = new SortedSet<KeyValuePair<string, int>>(new HotSentencesComparer());
}

class HotSentencesComparer : IComparer<KeyValuePair<string, int>>
{
    public int Compare(KeyValuePair<string, int> a, KeyValuePair<string, int> b)
    { 
        if(a.Value == b.Value) 
        { return a.Key.CompareTo(b.Key); }
        return b.Value.CompareTo(a.Value);
    }
}
}