//Author: Tushar Jaiswal
//Creation Date: 03/15/2018

/*Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.*/

public class Solution {
    public int TrailingZeroes(int n) {
        int result = 0;
        while(n != 0)
        {
            n /= 5;
            result += n;
        }
        return result;
    }
}