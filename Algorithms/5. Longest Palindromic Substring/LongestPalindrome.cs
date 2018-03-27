//Author: Tushar Jaiswal
//Creation Date: 03/27/2018

/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example:
Input: "cbbd"
Output: "bb"*/

public class Solution {
    public string LongestPalindrome(string s) {
        int len = s.Length;
        bool[,] palindromes = new bool[len, len]; 
        int maxLength = 0;
        string result = ""; 
        for(int l = 0; l < len; l++)
        {
            for(int i = 0; i < len - l; i++)
            {
                int j = i + l;
                if(s[i] == s[j] && ((j - i <= 2 || palindromes[i + 1, j - 1])))
                { 
                    palindromes[i, j] = true; 
                    if(maxLength < j - i + 1)
                    {
                        maxLength = j - i + 1;
                        result = s.Substring(i, maxLength);
                    }
                }
            }
        }
        return result;
    }
}