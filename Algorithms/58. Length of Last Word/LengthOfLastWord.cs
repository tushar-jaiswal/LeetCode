//Author: Tushar Jaiswal
//Creation Date: 06/26/2016
/*Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.*/
public class Solution {
    public int LengthOfLastWord(string s) {
        int length = 0, prevLength = 0;
        foreach(char c in s)
        {
            if(c != ' ')
            { length++; }
            else
            { 
                if(length != 0)
                {
                    prevLength = length;
                }
                length = 0; 
            }
        }
        if(length == 0 && prevLength !=0 )
        { return prevLength; }
        else
        { return length; }
    }
}