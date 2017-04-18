//Author: Tushar Jaiswal
//Creation Date: 04/17/2017

/*Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

public class Solution {
    public bool WordPattern(string pattern, string str) {
        Dictionary<char, string> dict = new Dictionary<char, string>();
        string[] words = str.Split(' ');
        
        if(pattern.Length != words.Length)
        { return false; }
        
        for(int i = 0; i < pattern.Length; i++)
        {
            char c = pattern[i];
            if(dict.ContainsKey(c))
            {
                if(!dict[c].Equals(words[i]))
                { return false; }
            }
            else
            {
                if(dict.ContainsValue(words[i]))
                { return false; }
                dict[c] = words[i];
            }
        }
        
        return true;
    }
}