//Author: Tushar Jaiswal
//Creation Date: 06/26/2016
/*Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.*/
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        digits[digits.length-1] += 1;
        if(digits[digits.length-1] == 10)
        {
            digits[digits.length-1] = 0;
        }
        else
        { return digits; }
        
        for(int i = digits.length-2; i >= 0; i--)
        {
            digits[i] += carry; 
            if(digits[i] == 10)
            {
                digits[i] = 0;
            }
            else
            { return digits; }
        }
        
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for(int i = 0; i < digits.length; i++)
        {
            result[i+1] = digits[i];
        }
        return result;
    }
}