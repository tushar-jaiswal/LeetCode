//Author: Tushar Jaiswal
//Creation Date: 06/14/2017

/*Given two strings s and t which consist of only lowercase letters.
String t is generated by random shuffling string s and then add one more letter at a random position.
Find the letter that was added in t.

Example:
Input:
s = "abcd"
t = "abcde"
Output: e
Explanation: 'e' is the letter that was added.*/

public class Solution {
    public char FindTheDifference(string s, string t) {
        Dictionary<char, int> sChars = new Dictionary<char, int>();
        Dictionary<char, int> tChars = new Dictionary<char, int>();
        
        foreach(char c in s)
        {
            if(sChars.ContainsKey(c))
            {
                sChars[c]++;
            }
            else
            {
                sChars[c] = 1;
            }
        }
        
        foreach(char c in t)
        {
            if(tChars.ContainsKey(c))
            {
                tChars[c]++;
            }
            else
            {
                tChars[c] = 1;
            }
        }
        
        foreach(KeyValuePair<char, int> kvp in tChars)
        {
            if(sChars.ContainsKey(kvp.Key))
            {
                if(sChars[kvp.Key] != kvp.Value)
                {
                    return kvp.Key;
                }
            }
            else
            {
                return kvp.Key;
            }
        }
        return '0';
    }
}