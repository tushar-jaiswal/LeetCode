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
        string result = ""; 
        for(int mid = 0; mid < s.Length; mid++)
        {
            string str = ExpandAroundMid(s, mid - 1, mid + 1);
            if(str.Length > result.Length)
            { result = str; }
            str = ExpandAroundMid(s, mid, mid + 1);
            if(str.Length > result.Length)
            { result = str; }
        }
        return result;
    }
    
    public string ExpandAroundMid(string s, int i, int j)
    {
        string result = "";
        while(i >= 0 && j < s.Length && s[i] == s[j])
        {
            i--; 
            j++;
        }
        i++;
        j--;
        if(i <= j)
        {
            result = s.Substring(i, j - i + 1);
        }
        return result;
    }
}