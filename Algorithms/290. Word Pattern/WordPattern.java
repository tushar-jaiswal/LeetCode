//Author: Tushar Jaiswal
//Creation Date: 04/17/2017

/*Given a pattern and a string str, find if str follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes: You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hm = new HashMap<Character, String>();
        String[] words = str.split(" ");
        
        if(pattern.length() != words.length)
        { return false; }
        
        for(int i = 0; i < pattern.length(); i++)
        {
            char c = pattern.charAt(i);
            if(hm.containsKey(c))
            {
                if(!hm.get(c).equals(words[i]))
                { return false; }
            }
            else
            {
                if(hm.containsValue(words[i]))
                { return false; }
                hm.put(c, words[i]);
            }
        }
        
        return true;
    }
}