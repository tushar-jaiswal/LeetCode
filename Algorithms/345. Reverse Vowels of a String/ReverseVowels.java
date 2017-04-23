//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Write a function that takes a string as input and reverse only the vowels of a string.
Example 1: Given s = "hello", return "holle".
Example 2: Given s = "leetcode", return "leotcede".
Note: The vowels does not include the letter "y".*/

public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = s.length() - 1; i < j;)
        {
            if(isVowel(chars[i]) && isVowel(chars[j]))
            {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
                continue;
            }
            if(!isVowel(chars[i]))
            { i++; }
            if(!isVowel(chars[j]))
            { j--; }
            
        }
        return new String(chars);
    }
    
    public boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? true : false;
    }
}