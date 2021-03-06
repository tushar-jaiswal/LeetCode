//Author: Tushar Jaiswal
//Creation Date: 01/07/2018

/*Implement int sqrt(int x).
Compute and return the square root of x. x is guaranteed to be a non-negative integer.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.*/

public class Solution {
    public int MySqrt(int x) {
        double d = (double)x;
        for(double i = 0; i <= d ; i++)
        {
            if(i * i <= x && ((i + 1) * (i + 1)) > x)
            {
                return (int)i;
            }
        }
        return 1;        
    }
}