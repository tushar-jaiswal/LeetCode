//Author: Tushar Jaiswal
//Creation Date: 07/23/2017

/*Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int num1Len = num1.length();
        int num2Len = num2.length();
        char carry = '0';
        int i, sum;
        
        for(i = 1; i <= num1Len && i <= num2Len; i++)
        {
            sum = num1.charAt(num1Len - i) + num2.charAt(num2Len - i) + carry - (48 * 3);
            result.insert(0, sum % 10);
            carry = (sum / 10 == 1) ? '1' : '0';
        }
        
        while(i <= num1Len)
        {
            if(carry == '1')
            {
                sum = num1.charAt(num1Len - i) + carry - (48 * 2);
                result.insert(0, sum % 10);
                carry = (sum / 10 == 1) ? '1' : '0';
            }
            else
            {
                result.insert(0, num1.charAt(num1Len - i));
            }
            i++;
        }
        while(i <= num2Len)
        {
            if(carry == '1')
            {
                sum = num2.charAt(num2Len - i) + carry - (48 * 2);
                result.insert(0, sum % 10);
                carry = (sum / 10 == 1) ? '1' : '0';
            }
            else
            {
                result.insert(0, num2.charAt(num2Len - i));
            }
            i++;
        }
        
        if(carry == '1')
        {
            result.insert(0, carry);
        }
        
        return result.toString();
    }
}