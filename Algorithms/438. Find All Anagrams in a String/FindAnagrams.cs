//Author: Tushar Jaiswal
//Creation Date: 08/15/2017

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input: s: "cbaebabacd" p: "abc"
Output: [0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s: "abab" p: "ab"
Output: [0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/

public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        List<int> indexes = new List<int>();
        if(p.Length > s.Length)
        { return indexes; }
        
        int i;
        List<char> requiredChars = new List<char>();
        List<char> extraChars = new List<char>();
        
        requiredChars.AddRange(p);
        
        for(i = 0; i < p.Length; i++)
        {
            char c = s[i];
            if(requiredChars.Contains(c))
            {
                requiredChars.Remove(c);
            }
            else
            {
                extraChars.Add(c);
            }
        }
        
        if(requiredChars.Count == 0)
        {
            indexes.Add(0);
        }
        
        for(; i < s.Length; i++)
        {
            char oldChar = s[i - p.Length];
            if(extraChars.Contains(oldChar))
            {
                extraChars.Remove(oldChar);
            }
            else
            {
                requiredChars.Add(oldChar);
            }
            
            char newChar = s[i];
            if(requiredChars.Contains(newChar))
            {
                requiredChars.Remove(newChar);
            }
            else
            {
                extraChars.Add(newChar);
            }
            
            if(requiredChars.Count == 0 && extraChars.Count == 0)
            {
                indexes.Add(i - p.Length + 1);
            }
        }
        
        return indexes;
    }
}