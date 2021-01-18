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
For every starting index, the search can continue till the end of the given string giving n^2. Substring operation is also n. In total, we have O(n^3).
Space Complexity: O(max(n, size of wordDict)) */

public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        HashSet<string> dict = new HashSet<string>(wordDict);
        Queue<int> toVisit = new Queue<int>();
        HashSet<int> visited = new HashSet<int>();
        toVisit.Enqueue(0);
        while(toVisit.Count != 0)
        {
            int pos = toVisit.Dequeue();
            if(!visited.Contains(pos))
            {
                visited.Add(pos);
                for(int i = pos + 1; i <= s.Length; i++)
                {
                    if(dict.Contains(s.Substring(pos, i - pos)))
                    {
                        if(i == s.Length)
                        { return true; }
                        toVisit.Enqueue(i);
                    }
                }
            }
        }
        return false;
    }
}
