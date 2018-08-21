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

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result; 
    }
    
    private void backtrack(List<String> result, String str, int open, int close, int n)
    {
        if(str.length() == n * 2)
        { 
            result.add(str);
            return; 
        }
        
        if(open < n)
        {
            backtrack(result, str + "(", open + 1, close, n);
        }
        if(close < open)
        {
            backtrack(result, str + ")", open, close + 1, n);
        }
    }
}