//Author: Tushar Jaiswal
//Creation Date: 08/20/2018

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]*/

public class Solution {
    public IList<string> GenerateParenthesis(int n) {
        List<string> result = new List<string>();
        Backtrack(result, "", 0, 0, n);
        return result; 
    }
    
    private void Backtrack(IList<String> result, string str, int open, int close, int n)
    {
        if(str.Length == n * 2)
        { 
            result.Add(str);
            return; 
        }
        
        if(open < n)
        {
            Backtrack(result, str + "(", open + 1, close, n);
        }
        if(close < open)
        {
            Backtrack(result, str + ")", open, close + 1, n);
        }
    }
}