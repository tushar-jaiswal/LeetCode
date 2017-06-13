//Author: Tushar Jaiswal
//Creation Date: 06/12/2017

/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Note: You may assume that both strings contain only lowercase letters.
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomChars = new HashMap<Character, Integer>();
        HashMap<Character, Integer> magazineChars = new HashMap<Character, Integer>();
        
        for(char c: ransomNote.toCharArray())
        {
            Integer count = ransomChars.get(c);
            if(count == null)
            {
                ransomChars.put(c, 1);
            }
            else
            {
                ransomChars.put(c, count + 1);
            }
        }
        
        for(char c: magazine.toCharArray())
        {
            Integer count = magazineChars.get(c);
            if(count == null)
            {
                magazineChars.put(c, 1);
            }
            else
            {
                magazineChars.put(c, count + 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: ransomChars.entrySet())
        {
            Integer magazineCharCount = magazineChars.get(entry.getKey());
            if(magazineCharCount == null || magazineCharCount < entry.getValue())
            {
                return false;
            }
        }
        return true;
    }
}