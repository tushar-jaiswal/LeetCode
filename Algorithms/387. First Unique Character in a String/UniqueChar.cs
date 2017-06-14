//Author: Tushar Jaiswal
//Creation Date: 06/13/2017

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode", return 0.
s = "loveleetcode", return 2.*/

public class Solution {
    public int FirstUniqChar(string s) {
        Dictionary<char, int> chars = new Dictionary<char, int>();
        for(int i = 0; i < s.Length; i++)
        {
            if(chars.ContainsKey(s[i]))
            { 
                chars[s[i]] = -1;
            }
            else
            {
                chars[s[i]] = i;
            }
        }
        
        foreach(int value in chars.Values)
        {
            if(value != -1)
            { 
                return value; 
            }
        }
        return -1;
    }
}