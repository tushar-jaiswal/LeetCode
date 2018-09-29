//Author: Tushar Jaiswal
//Creation Date: 09/29/2018

/*Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

Example:
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]*/

public class Solution {
    public IList<IList<string>> Partition(string s) {
        IList<IList<string>> result = new List<IList<string>>();
        AllPartitionsFrom(0, s, new List<string>(), result);
        return result;
    }
    
    public void AllPartitionsFrom(int pos, string s, List<string> curr, IList<IList<string>> result)
    {
        if(pos == s.Length)
        { result.Add(curr); }
        
        for(int len = 1; len <= s.Length - pos; len++)
        { 
            string str = s.Substring(pos, len);
            if(IsPalindrome(str))
            {
                List<string> newCurr = new List<string>(curr);
                newCurr.Add(str);
                AllPartitionsFrom(pos + len, s, newCurr, result);
            }
        }
    }

    public bool IsPalindrome(string s)
    {
        for(int i = 0, j = s.Length - 1; i < j; i++, j--)
        {
            if(s[i] != s[j])
            { return false; }	
        }
        return true;
    }
}