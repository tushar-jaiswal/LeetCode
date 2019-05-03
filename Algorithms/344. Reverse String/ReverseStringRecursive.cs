//Author: Tushar Jaiswal
//Creation Date: 05/03/2019

/*Write a function that reverses a string. The input string is given as an array of characters char[].
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
You may assume all the characters consist of printable ascii characters.

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]*/

public class Solution {
    public void ReverseString(char[] s) {
        Helper(s, 0);
    }

    private void Helper(char[] s, int pos) {
        int len = s.Length;
        if(pos >= len / 2)
        { return; }
        char temp = s[pos];
        s[pos] = s[len - 1 - pos];
        s[len - 1 - pos] = temp;
        Helper(s, pos + 1);
    }
}
