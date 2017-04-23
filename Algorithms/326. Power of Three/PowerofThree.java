//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Given an integer, write a function to determine if it is a power of three.
Follow up: Could you do it without using any loop / recursion?*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0)
        { return false; }
        if(n == 1)
        { return true; }
        while(n % 3 == 0 && n != 3)
        {
            n /= 3;
        }
        return (n % 3 == 0) ? true : false;
    }
}