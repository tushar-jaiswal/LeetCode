//Author: Tushar Jaiswal
//Creation Date: 04/02/2017

/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        
        for(char c : s.toCharArray())
        {
            if(charCount.containsKey(c))
            {
                charCount.put(c, charCount.get(c) + 1);
            }
            else
            {
                charCount.put(c, 1);
            }
        }
        
        for(char c : t.toCharArray())
        {
            if(charCount.containsKey(c))
            {
                charCount.put(c, charCount.get(c) - 1);
            }
            else
            { return false; }
        }
        
        for(Integer count : charCount.values())
        {
            if(count != 0)
            {
                return false;
            }
        }
        return true;
    }
}