//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Write a function that takes a string as input and returns the string reversed.
Example: Given s = "hello", return "olleh".*/

public class Solution {
    public string ReverseString(string s) {
        char[] chars = s.ToCharArray();
        for(int i = 0, j = s.Length - 1; i < j; i++, j--)
        {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new string(chars);
    }
}