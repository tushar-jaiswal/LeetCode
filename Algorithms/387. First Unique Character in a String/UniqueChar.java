//Author: Tushar Jaiswal
//Creation Date: 06/14/2017

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode", return 0.
s = "loveleetcode", return 2.*/

public class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> chars = new LinkedHashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(chars.containsKey(c))
            { 
                chars.put(c, -1);
            }
            else
            {
                chars.put(c, i);
            }
        }
        
        for(Integer value : chars.values())
        {
            if(value != -1)
            { 
                return value; 
            }
        }
        return -1;
    }
}