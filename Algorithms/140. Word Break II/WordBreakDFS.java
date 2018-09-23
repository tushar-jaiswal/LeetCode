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

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<String>(wordDict);
        HashSet<Integer> invalidPositions = new HashSet<Integer>();
        HashSet<Integer> validPositions = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        canBreakFrom(0, s, dict, invalidPositions, validPositions, new StringBuilder(), result);
        return result; 
    }
    
    public boolean canBreakFrom(int pos, String s, HashSet<String> dict, HashSet<Integer> invalidPositions, HashSet<Integer> validPositions, StringBuilder curr, List<String> result)
    {
        if(invalidPositions.contains(pos))
        { return false; }
        for(int i = pos + 1; i <= s.length(); i++)
        {
            String word = s.substring(pos, i);
            if(dict.contains(word))
            {
                StringBuilder newCurr = new StringBuilder(curr);
                newCurr.append(" ");
                newCurr.append(word);
                if(i == s.length())
                { 
                    result.add(newCurr.toString().substring(1, newCurr.length())); 
                    validPositions.add(pos);
                    return true;
                }
                else if(canBreakFrom(i, s, dict, invalidPositions, validPositions, newCurr, result))
                { validPositions.add(pos); }
                else if(!validPositions.contains(i))
                { invalidPositions.add(i); }
            }
        }
        if(validPositions.contains(pos))
        { return true; }
        else
        { return false; }
    }
}