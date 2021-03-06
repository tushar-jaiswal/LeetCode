//Author: Tushar Jaiswal
//Creation Date: 01/06/2018

/*Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)*/

public class Solution {
    public bool RepeatedSubstringPattern(string s) {
        for(int i = 1; i < s.Length; i++)
        {
            if(s[i] == s[0])
            {
                for(int j = i, k = 0, len = i; j < s.Length; j++)
                {
                    if(s[j] != s[k])
                    {
                        break;
                    }
                    if(k == len - 1)
                    { 
                        k = 0;
                        if(j == s.Length - 1)
                        {
                            return true;
                        }
                    }
                    else
                    {
                        k++;
                    }
                }
            }
        }
        return false;
    }
}