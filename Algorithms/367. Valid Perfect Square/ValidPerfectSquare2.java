//Author: Tushar Jaiswal
//Creation Date: 06/30/2018

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
        long low = 1, high = num / 2 + 1;
        while(low <= high)
        {
            long mid = low + (high - low) / 2;
            if(mid * mid == num)
            { return true; }
            else if(mid * mid > num)
            { high = mid - 1; }
            else
            { low = mid + 1; }
        }
        return false;
    }
}