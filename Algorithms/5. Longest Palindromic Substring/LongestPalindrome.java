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

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] palindromes = new boolean[len][len]; 
        int maxLength = 0;
        String result = ""; 
        for(int l = 0; l < len; l++)
        {
            for(int i = 0; i < len - l; i++)
            {
                int j = i + l;
                if(s.charAt(i) == s.charAt(j) && ((j - i <= 2 || palindromes[i + 1][j - 1])))
                { 
                    palindromes[i][j] = true; 
                    if(maxLength < j - i + 1)
                    {
                        maxLength = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}