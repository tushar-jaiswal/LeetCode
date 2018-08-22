//Author: Tushar Jaiswal
//Creation Date: 08/21/2018

/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note: Although the above answer is in lexicographical order, your answer could be in any order you want.*/

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0)
        { return result; }
        generateCombination(result, "", digits, 0);
        return result;
    }
    
    private void generateCombination(List<String> result, String str, String digits, int pos)
    {
        if(pos == digits.length())
        {
            result.add(str);
            return;
        }
        
        int n = digits.charAt(pos) - '0';
        String[] letters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for(char c : letters[n].toCharArray())
        {
            generateCombination(result, str + c, digits, pos + 1);
        }
    }
}