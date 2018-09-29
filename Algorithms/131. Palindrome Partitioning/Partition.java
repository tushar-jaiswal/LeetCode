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

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        allPartitionsFrom(0, s, new ArrayList<String>(), result);
        return result;
    }
    
    public void allPartitionsFrom(int pos, String s, List<String> curr, List<List<String>> result)
    {
        if(pos == s.length())
        { result.add(curr); }
        
        for(int len = 1; len <= s.length() - pos; len++)
        { 
            String str = s.substring(pos, pos + len);
            if(isPalindrome(str))
            {
                List<String> newCurr = new ArrayList<String>(curr);
                newCurr.add(str);
                allPartitionsFrom(pos + len, s, newCurr, result);
            }
        }
    }

    public boolean isPalindrome(String s)
    {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--)
        {
            if(s.charAt(i) != s.charAt(j))
            { return false; }	
        }
        return true;
    }
}