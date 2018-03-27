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
        String result = ""; 
        for(int mid = 0; mid < s.length(); mid++)
        {
            String str = expandAroundMid(s, mid - 1, mid + 1);
            if(str.length() > result.length())
            { result = str; }
            str = expandAroundMid(s, mid, mid + 1);
            if(str.length() > result.length())
            { result = str; }
        }
        return result;
    }
    
    public String expandAroundMid(String s, int i, int j)
    {
        String result = "";
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--; 
            j++;
        }
        i++;
        j--;
        if(i <= j)
        {
            result = s.substring(i, j + 1);
        }
        return result;
    }
}