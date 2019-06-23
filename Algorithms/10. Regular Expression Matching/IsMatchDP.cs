//Author: Tushar Jaiswal
//Creation Date: 06/23/2019

/*Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:
s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:
Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:
Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:
Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:
Input:
s = "mississippi"
p = "mis*is*p*."
Output: false*/

enum Match{
        False,
        True
    }

public class Solution {
    Match[,] memo;

    public bool IsMatch(string s, string p) {
        memo = new Match[s.Length + 1, p.Length + 1];
        return DP(0, 0, s, p);
    }

    private bool DP(int i, int j, string s, string p)
    {
        if(memo[i, j] != null)
        { return memo[i, j] == Match.True; }
        if(j == p.Length)
        { return i == s.Length; }

        bool charMatch = (i < s.Length) && (s[i] == p[j] || p[j] == '.');
        bool result;
        if(p.Length > j + 1 && p[j + 1] == '*')
        { result = DP(i, j + 2, s, p) || (charMatch && DP(i + 1, j, s, p)); }
        else
        { result = charMatch && DP(i + 1, j + 1, s, p); }

        memo[i, j] = result ? Match.True : Match.False;
        return result;
    }
}
