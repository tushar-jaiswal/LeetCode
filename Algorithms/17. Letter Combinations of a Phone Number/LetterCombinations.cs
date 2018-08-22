//Author: Tushar Jaiswal
//Creation Date: 08/21/2018

/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note: Although the above answer is in lexicographical order, your answer could be in any order you want.*/

public class Solution {
    public IList<string> LetterCombinations(string digits) {
        List<string> result = new List<string>();
        if(digits.Length == 0)
        { return result; }
        GenerateCombination(result, "", digits, 0);
        return result;
    }
    
    private void GenerateCombination(List<string> result, string str, string digits, int pos)
    {
        if(pos == digits.Length)
        {
            result.Add(str);
            return;
        }
        
        int n = digits[pos] - '0';
        string[] letters = new string[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        foreach(char c in letters[n])
        {
            GenerateCombination(result, str + c, digits, pos + 1);
        }
    }
}