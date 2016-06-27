//Author: Tushar Jaiswal
//Creation Date: 06/26/2016
/*Given a non-negative number represented as an array of digits, plus one to the number.
The digits are stored such that the most significant digit is at the head of the list.*/
public class Solution {
    public int[] PlusOne(int[] digits) {
        digits[digits.Length-1] += 1;
        if(digits[digits.Length-1] == 10)
        {
            digits[digits.Length-1] = 0;
        }
        else
        { return digits; }
        
        for(int i= digits.Length-2; i >= 0; i--)
        {
            digits[i] += 1;
            if(digits[i] == 10)
            {
                digits[i] = 0;
            }
            else
            { return digits; }
        }
        
        digits = new int[digits.Length+1];
        digits[0] = 1;
        return digits;
    }
}