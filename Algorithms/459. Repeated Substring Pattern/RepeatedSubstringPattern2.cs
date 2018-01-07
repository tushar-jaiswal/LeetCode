//Author: Tushar Jaiswal
//Creation Date: 01/07/2018

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
        int len = s.Length;
        for(int subLen = len / 2; subLen > 0; subLen--)
        {
            if(len % subLen == 0)
            {
                string subStr = s.Substring(0, subLen);
                int i;
                for(i = 1; i < len / subLen; i++)
                {
                    string test = s.Substring(subLen * i, subLen);
                    if(!subStr.Equals(test))
                    {
                        break;
                    }
                }
                if(i * subLen == len)
                {
                    return true;
                }
            }
        }
        return false;
    }
}