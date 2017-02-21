//Author: Tushar Jaiswal
//Creation Date: 02/14/2017

/*Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.

Note: You may assume both s and t have the same length.*/

public class Solution {
    public bool IsIsomorphic(string s, string t) {
        Dictionary<char, char> dict = new Dictionary<char, char>();
        
        for(int i = 0; i < s.Length; i++)
        {
            if(dict.ContainsKey(s[i]))
            {
                char c;
                dict.TryGetValue(s[i], out c);
                if(c != t[i])
                { return false; }
            }
            else if(dict.ContainsValue(t[i]))
            { return false; }
            else
            {
                dict.Add(s[i], t[i]);
            }
        }
        
        return true;
    }
}