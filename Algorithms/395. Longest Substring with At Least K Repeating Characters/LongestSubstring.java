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

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }

    public int helper(String s, int k)
    {
        int maxLen = 0;
        boolean isStringSplit = false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() < k)
            {
                isStringSplit = true;
                String[] arr = s.split(entry.getKey().toString());
                for(String subStr : arr)
                {
                    maxLen = Math.max(maxLen, helper(subStr, k));
                }
                break;
            }
        }
        return !isStringSplit ? s.length() : maxLen;
    }
}
