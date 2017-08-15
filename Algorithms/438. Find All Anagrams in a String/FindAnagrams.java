//Author: Tushar Jaiswal
//Creation Date: 08/14/2017

/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input: s: "cbaebabacd" p: "abc"
Output: [0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s: "abab" p: "ab"
Output: [0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<Integer>();
        if(p.length() > s.length())
        { return indexes; }
        
        int i;
        List<Character> requiredChars = new ArrayList<Character>();
        List<Character> extraChars = new ArrayList<Character>();
        for(char c : p.toCharArray())
        {
            requiredChars.add(c);
        }
        
        for(i = 0; i < p.length(); i++)
        {
            char c = s.charAt(i);
            if(requiredChars.contains(c))
            {
                requiredChars.remove((Character)c);
            }
            else
            {
                extraChars.add(c);
            }
        }
        
        if(requiredChars.size() == 0)
        {
            indexes.add(0);
        }
        
        for(; i < s.length(); i++)
        {
            char oldChar = s.charAt(i - p.length());
            if(extraChars.contains(oldChar))
            {
                extraChars.remove((Character)oldChar);
            }
            else
            {
                requiredChars.add(oldChar);
            }
            
            char newChar = s.charAt(i);
            if(requiredChars.contains(newChar))
            {
                requiredChars.remove((Character)newChar);
            }
            else
            {
                extraChars.add(newChar);
            }
            
            if(requiredChars.size() == 0 && extraChars.size() == 0)
            {
                indexes.add(i - p.length() + 1);
            }
        }
        
        return indexes;
    }
}