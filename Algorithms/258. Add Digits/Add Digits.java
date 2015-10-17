//Author: Tushar Jaiswal
//Creation Date: 10/17/2015

/*Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.*/
public class Solution {
    public int addDigits(int num) {
        int copy;
        
        while(num / 10 != 0)
        {
            copy = num;
            num = 0;
            do
            {
                num += copy % 10;
                copy /= 10;
            }while(copy / 10 != 0);
            num += copy;
        }
        return num;
    }
}