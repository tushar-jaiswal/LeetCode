//Author: Tushar Jaiswal
//Creation Date: 04/02/2017

/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

public class Solution {
    public bool IsAnagram(string s, string t) {
        if(s.Length != t.Length)
        { return false; }
        
        Dictionary<char, int> charCount = new Dictionary<char, int>();
        
        foreach(char c in s)
        {
            if(charCount.ContainsKey(c))
            {
                charCount[c] = charCount[c]++;
            }
            else
            {
                charCount[c] = 1;
            }
        }
        
        foreach(char c in t)
        {
            if(charCount.ContainsKey(c))
            {
                charCount[c] = charCount[c]--;
                if(charCount[c] < 0)
                {
                    return false;
                }
            }
            else
            { return false; }
        }
        
        foreach(int count in charCount.Values)
        {
            if(count != 0)
            {
                return false;
            }
        }
        return true;
    }
}