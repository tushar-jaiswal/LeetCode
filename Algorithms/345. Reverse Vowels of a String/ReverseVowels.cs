//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Write a function that takes a string as input and reverse only the vowels of a string.
Example 1: Given s = "hello", return "holle".
Example 2: Given s = "leetcode", return "leotcede".
Note: The vowels does not include the letter "y".*/

public class Solution {
    public string ReverseVowels(string s) {
        char[] chars = s.ToCharArray();
        for(int i = 0, j = s.Length - 1; i < j;)
        {
            if(IsVowel(chars[i]) && IsVowel(chars[j]))
            {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
                continue;
            }
            if(!IsVowel(chars[i]))
            { i++; }
            if(!IsVowel(chars[j]))
            { j--; }
            
        }
        return new string(chars);
    }
    
    public bool IsVowel(char c)
    {
        c = Char.ToLower(c);
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? true : false;
    }
}