//Author: Tushar Jaiswal
//Creation Date: 07/10/2017

/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters. This is case sensitive, for example "Aa" is not considered a palindrome here.
Note: Assume the length of given string will not exceed 1,010.

Example:
Input: "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.*/

public class Solution {
    public int LongestPalindrome(string s) {
        Dictionary<char, int> chars = new Dictionary<char, int>();
        int length = 0;
        bool hasOddFreq = false;
        
        for(int i = 0; i < s.Length; i++)
        {
            if(chars.ContainsKey(s[i]))
            {
                chars[s[i]] += 1;
            }
            else
            {
                chars[s[i]] = 1;
            }
        }
        
        foreach(int i in chars.Values)
        {
            if(i % 2 == 0)
            { 
                length += i; 
            }
            else
            { 
                length += i - 1;
                hasOddFreq = true;
            }
        }
        if(hasOddFreq) 
        {
            length += 1;
        }
        
        return length;
    }
}