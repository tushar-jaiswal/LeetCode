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

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < words.length; i++)
        {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            map.put(reverse, i);
        }
        
        if(map.containsKey(""))
        {
            for(int i = 0; i < words.length; i++)
            {
                if(words[i].equals(""))
                { continue; }
                if(isPalindrome(words[i]))
                {
                    result.add(Arrays.asList(map.get(""), i));
                }
            }
        }
        
        for(int i = 0; i < words.length; i++)
        {
            for(int j = 0; j < words[i].length(); j++)
            {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j, words[i].length());
                
                if(map.containsKey(right) && isPalindrome(left) && map.get(right) != i)
                {
                    result.add(Arrays.asList(map.get(right), i));
                }
                if(map.containsKey(left) && isPalindrome(right) && map.get(left) != i)
                {
                    result.add(Arrays.asList(i, map.get(left)));
                }
            }
        }
        return result;        
    }
    
    public boolean isPalindrome(String s)
    {
        if(s == null)
        {
            return false;
        }
        for(int i = 0, j = s.length() - 1; i < j; i++, j--)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false; 
            }
        }
        return true;
    }
}