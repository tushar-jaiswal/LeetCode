//Author: Tushar Jaiswal
//Creation Date: 08/18/2018

/*Given a non-empty list of words, return the k most frequent elements. Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words. Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements. Input words contain only lowercase letters.
Follow up: Try to solve it in O(n log k) time and O(n) extra space.*/

public class Solution {
    public IList<string> TopKFrequent(string[] words, int k) {
        SortedSet<Element> sSet = new SortedSet<Element>(new ElementComparer());
        Dictionary<string, int> map = new Dictionary<string, int>(); 
        List<string> result = new List<string>();
        foreach(string word in words)
        {
            if(map.ContainsKey(word))
            { map[word] += 1; }
            else
            { map.Add(word, 1); }
        }
        
        foreach(KeyValuePair<string, int> kvp in map)
        {
            sSet.Add(new Element(kvp.Key, kvp.Value));
            if(sSet.Count > k)
            { sSet.Remove(sSet.First()); }
        }
        
        while(sSet.Count > 0)
        { 
            result.Insert(0, sSet.First().word); 
            sSet.Remove(sSet.First());
        }
        return result;
    }
}

public class Element
{
    public string word;
    public int frequency;
    
    public Element(string word, int frequency)
    {
        this.word = word;
        this.frequency = frequency;
    }
}

public class ElementComparer : IComparer<Element>
{
    public int Compare(Element a, Element b)
    {
        if(a.frequency == b.frequency)
        { return b.word.CompareTo(a.word); }
        return a.frequency.CompareTo(b.frequency);
    }
}