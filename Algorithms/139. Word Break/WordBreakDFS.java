//Author: Tushar Jaiswal
//Creation Date: 09/22/2018

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

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>(wordDict);
        HashSet<Integer> invalidPositions = new HashSet<Integer>();
        return canBreakFrom(0, s, dict, invalidPositions);
    }
    
    public boolean canBreakFrom(int pos, String s, HashSet<String> dict, HashSet<Integer> invalidPositions)
    {
        if(invalidPositions.contains(pos))
        { return false; }
        StringBuilder sb = new StringBuilder();
        for(int i = pos; i < s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString()))
            {
                if(i + 1 == s.length() || canBreakFrom(i + 1, s, dict, invalidPositions))
                { return true; }
                else
                { invalidPositions.add(i + 1); }
            }
        }
        return false;
    }
}