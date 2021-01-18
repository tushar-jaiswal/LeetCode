//Author: Tushar Jaiswal
//Creation Date: 09/23/2018

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false*/

/*Runtime Complexity: O(n^3) where n is the length of the string s.
Size of recursion tree can go up to n^2. StringBuilder's ToString operation is also n. In total, we have O(n^3).
Space Complexity: O(max(n, size of wordDict)) */

public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        HashSet<string> dict = new HashSet<string>(wordDict);
        HashSet<int> invalidPositions = new HashSet<int>();
        return CanBreakFrom(0, s, dict, invalidPositions);
    }

    public bool CanBreakFrom(int pos, string s, HashSet<string> dict, HashSet<int> invalidPositions)
    {
        if(invalidPositions.Contains(pos))
        { return false; }
        StringBuilder sb = new StringBuilder();
        for(int i = pos; i < s.Length; i++)
        {
            sb.Append(s[i]);
            if(dict.Contains(sb.ToString()))
            {
                if(i + 1 == s.Length || CanBreakFrom(i + 1, s, dict, invalidPositions))
                { return true; }
                else
                { invalidPositions.Add(i + 1); }
            }
        }
        return false;
    }
}
