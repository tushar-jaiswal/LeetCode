//Author: Tushar Jaiswal
//Creation Date: 09/23/2018

/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.

Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: []*/

public class Solution {
    public IList<string> WordBreak(string s, IList<string> wordDict) {
        HashSet<string> dict = new HashSet<string>(wordDict);
        HashSet<int> invalidPositions = new HashSet<int>();
        HashSet<int> validPositions = new HashSet<int>();
        IList<string> result = new List<string>();
        canBreakFrom(0, s, dict, invalidPositions, validPositions, new StringBuilder(), result);
        return result; 
    }
    
    public bool canBreakFrom(int pos, string s, HashSet<string> dict, HashSet<int> invalidPositions, HashSet<int> validPositions, StringBuilder curr, IList<string> result)
    {
        if(invalidPositions.Contains(pos))
        { return false; }
        for(int i = pos + 1; i <= s.Length; i++)
        {
            string word = s.Substring(pos, i - pos);
            if(dict.Contains(word))
            {
                StringBuilder newCurr = new StringBuilder(curr.ToString());
                newCurr.Append(" ");
                newCurr.Append(word);
                if(i == s.Length)
                { 
                    result.Add(newCurr.ToString().Substring(1, newCurr.Length - 1)); 
                    validPositions.Add(pos);
                    return true;
                }
                else if(canBreakFrom(i, s, dict, invalidPositions, validPositions, newCurr, result))
                { validPositions.Add(pos); }
                else if(!validPositions.Contains(i))
                { invalidPositions.Add(i); }
            }
        }
        if(validPositions.Contains(pos))
        { return true; }
        else
        { return false; }
    }
}