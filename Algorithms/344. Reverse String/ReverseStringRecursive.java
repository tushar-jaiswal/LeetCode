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

class Solution {
    public void reverseString(char[] s) {
        helper(s, 0);
    }

    private void helper(char[] s, int pos) {
        int len = s.length;
        if(pos >= len / 2)
        { return; }
        char temp = s[pos];
        s[pos] = s[len - 1 - pos];
        s[len - 1 - pos] = temp;
        helper(s, pos + 1);
    }
}
