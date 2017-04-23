//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Write a function that takes a string as input and returns the string reversed.
Example: Given s = "hello", return "olleh".*/

public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0, j = s.length() - 1; i < j; i++, j--)
        {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}