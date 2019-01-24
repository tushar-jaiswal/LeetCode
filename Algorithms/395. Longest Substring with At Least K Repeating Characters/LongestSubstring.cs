//Author: Tushar Jaiswal
//Creation Date: 01/23/2019

/*Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:
Input: s = "aaabb", k = 3
Output: 3
The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:
Input: s = "ababbc", k = 2
Output: 5
The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.*/

public class Solution {
    public int LongestSubstring(string s, int k) {
        return Helper(s, k);
    }

    public int Helper(string s, int k)
    {
        int maxLen = 0;
        bool isStringSplit = false;
        Dictionary<char, int> dict = new Dictionary<char, int>();
        foreach(char c in s)
        {
            if(dict.ContainsKey(c))
            {
                dict[c]++;
            }
            else
            {
                dict[c] = 1;
            }
        }
        foreach(KeyValuePair<char, int> kvp in dict)
        {
            if(kvp.Value < k)
            {
                isStringSplit = true;
                string[] arr = s.Split(kvp.Key, StringSplitOptions.RemoveEmptyEntries);
                foreach(string subStr in arr)
                {
                    maxLen = Math.Max(maxLen, Helper(subStr, k));
                }
                break;
            }
        }
        return !isStringSplit ? s.Length : maxLen;
    }
}
