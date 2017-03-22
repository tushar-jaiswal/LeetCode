//Author: Tushar Jaiswal
//Creation Date: 03/21/2017

/*Given an integer, write a function to determine if it is a power of two.*/

public class Solution {
    public bool IsPowerOfTwo(int n) {
        if(n == 1) 
        { return true; }
        
        while(n > 2)
        {
            int remainder = n % 2;
            if(remainder == 1)
            { return false; }
            n /= 2;
        }
        if(n == 2)
        { return true; }
        else
        { return false; }
    }
}