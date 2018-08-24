//Author: Tushar Jaiswal
//Creation Date: 08/23/2018

/*Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
Return the quotient after dividing dividend by divisor. The integer division should truncate toward zero.

Example 1:
Input: dividend = 10, divisor = 3
Output: 3

Example 2:
Input: dividend = 7, divisor = -3
Output: -2

Note:
Both dividend and divisor will be 32-bit signed integers. The divisor will never be 0. Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [-231,  231 - 1]. For the purpose of this problem, assume that your function returns 231 - 1 when the division result overflows.*/

public class Solution {
    public int Divide(int dividend, int divisor) {
        if(dividend == Int32.MinValue && divisor == -1)
        { return Int32.MaxValue; }
        
        int quotient = 0;
        bool isNegative = false;
        if((dividend >= 0 && divisor < 0) || (dividend < 0 && divisor > 0))
        { isNegative = true; }
        long lDivisor = Math.Abs((long)divisor);
        long lDividend = Math.Abs((long)dividend);
        
        long curr = lDivisor;
        long divid = lDividend;
        int count = 1;
        while(lDivisor <= divid)
        {
            if(curr < divid)
            {
                curr += curr;
                count += count;
            }
            if(curr > divid)
            {
                curr = lDivisor;
                count = 1;
            }
            divid -= curr;
            quotient += count;
        }
        if(isNegative)
        { quotient = 0 - quotient; }
        return quotient;
    }
}