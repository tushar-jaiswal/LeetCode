//Author: Tushar Jaiswal
//Creation Date: 10/12/2018

/*A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:
Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:
Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).*/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0')
        { return 0; }
        if(n == 1)
        { return 1; }
        
        int[] ways = new int[n + 1];
        ways[0] = ways[1] = 1;
        if(s.charAt(1) == '0')
        { ways[1] = 0; }

        for(int i = 2; i <= n; i++)
        {
            if((s.charAt(i - 2) == '1' && s.charAt(i - 1) != '0') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) > '0' && s.charAt(i - 1) < '7'))
            {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
            else if(s.charAt(i - 1) == '0' && s.charAt(i - 2) > '2')
            {
                return 0;
            }
            else if(s.charAt(i - 1) == '0')
            {
                ways[i] = ways[i - 2];
            }
            else
            {
                ways[i] = ways[i - 1];
            }
        }
        
        return ways[n];
    }
}