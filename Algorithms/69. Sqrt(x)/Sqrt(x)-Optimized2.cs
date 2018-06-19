//Author: Tushar Jaiswal
//Creation Date: 03/24/2018

/*Implement int sqrt(int x). Compute and return the square root of x. x is guaranteed to be a non-negative integer.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.*/

public class Solution {
    public int MySqrt(int x) {
        if(x == 0)
        { return 0; }
        if(x == 1) 
        { return 1; }
        
        int left = 1, right = x / 2;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            if(mid <= x / mid && (mid + 1) > x / (mid + 1))
            { return mid; }
            if(mid > x / mid)
            { right = mid - 1; }
            else 
            { left = mid + 1; }
        }
        return -1;
    }
}