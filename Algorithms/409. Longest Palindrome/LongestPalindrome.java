//Author: Tushar Jaiswal
//Creation Date: 07/10/2017

/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters. This is case sensitive, for example "Aa" is not considered a palindrome here.
Note: Assume the length of given string will not exceed 1,010.

Example:
Input: "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.*/

public class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        int length = 0;
        Boolean hasOddFreq = false;
        
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(chars.containsKey(c))
            {
                chars.put(c, chars.get(c) + 1);
            }
            else
            {
                chars.put(c, 1);
            }
        }
        
        for(Integer i : chars.values())
        {
            if(i % 2 == 0)
            { 
                length += i; 
            }
            else
            { 
                length += i - 1;
                hasOddFreq = true;
            }
        }
        if(hasOddFreq) 
        {
            length += 1;
        }
        
        return length;
    }
}