//Author: Tushar Jaiswal
//Creation Date: 04/27/2017

/*Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Returns: True

Example 2:
Input: 14
Returns: False*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        long x = num;
        while(x * x > num)
        {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}