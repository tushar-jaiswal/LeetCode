//Author: Tushar Jaiswal
//Creation Date: 10/09/2018

/*Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:
Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]*/

public class Solution {
    public IList<IList<int>> PalindromePairs(string[] words) {
        IList<IList<int>> result = new List<IList<int>>();
        Dictionary<string, int> dict = new Dictionary<string, int>();
        
        for(int i = 0; i < words.Length; i++)
        {
            char[] arr = words[i].ToCharArray();
            Array.Reverse(arr);
            string reverse = new string(arr);
            dict[reverse] = i;
        }
        
        if(dict.ContainsKey(""))
        {
            for(int i = 0; i < words.Length; i++)
            {
                if(words[i].Equals(""))
                { continue; }
                if(IsPalindrome(words[i]))
                {
                    result.Add(new List<int>(new int[]{dict[""], i}));
                }
            }
        }
        
        for(int i = 0; i < words.Length; i++)
        {
            for(int j = 0; j < words[i].Length; j++)
            {
                string left = words[i].Substring(0, j);
                string right = words[i].Substring(j, words[i].Length - j);
                
                if(dict.ContainsKey(right) && IsPalindrome(left) && dict[right] != i)
                {
                    result.Add(new List<int>(new int[]{dict[right], i}));
                }
                if(dict.ContainsKey(left) && IsPalindrome(right) && dict[left] != i)
                {
                    result.Add(new List<int>(new int[]{i, dict[left]}));
                }
            }
        }
        return result;        
    }
    
    public bool IsPalindrome(string s)
    {
        if(s == null)
        {
            return false;
        }
        for(int i = 0, j = s.Length - 1; i < j; i++, j--)
        {
            if(s[i] != s[j])
            {
                return false; 
            }
        }
        return true;
    }
}