//Author: Tushar Jaiswal
//Creation Date: 06/12/2017

/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Note: You may assume that both strings contain only lowercase letters.
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/

public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        Dictionary<char, int> ransomChars = new Dictionary<char, int>();
        Dictionary<char, int> magazineChars = new Dictionary<char, int>();
        
        foreach(char c in ransomNote.ToCharArray())
        {
            if(!ransomChars.ContainsKey(c))
            {
                ransomChars[c] = 1;
            }
            else
            {
                ransomChars[c]++;
            }
        }
        
        foreach(char c in magazine.ToCharArray())
        {
            if(!magazineChars.ContainsKey(c))
            {
                magazineChars[c] = 1;
            }
            else
            {
                magazineChars[c]++;
            }
        }
        
        foreach(KeyValuePair<char, int> kvp in ransomChars)
        {
            int count = magazineChars.ContainsKey(kvp.Key) ? magazineChars[kvp.Key] : -1;
            if(count < kvp.Value)
            {
                return false;
            }
        }
        return true;
    }
}