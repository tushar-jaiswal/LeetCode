//Author: Tushar Jaiswal
//Creation Date: 07/19/2016
/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.*/
public class Solution {
    public bool IsPalindrome(string s) {
        for(int i = 0, j = s.Length-1; i < j; i++, j--)
        {
            while(i < j && !Char.IsLetterOrDigit(s[i]))
            { i++; }
            while(j > i && !Char.IsLetterOrDigit(s[j]))
            { j--; }
            
            if(i < j)
            {
                if(Char.ToLower(s[i]) != Char.ToLower(s[j]))
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}