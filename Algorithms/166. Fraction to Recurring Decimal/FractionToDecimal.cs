//Author: Tushar Jaiswal
//Creation Date: 10/04/2018

/*Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:
Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:
Input: numerator = 2, denominator = 1
Output: "2"

Example 3:
Input: numerator = 2, denominator = 3
Output: "0.(6)"*/

public class Solution {
    public string FractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
        {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.Append((numerator < 0) ^ (denominator < 0) ? "-" : "");
        long num = Math.Abs((long)numerator);
        long den = Math.Abs((long)denominator);
        long quotient = num / den;
        long remainder = num % den;
        result.Append(quotient);
        if(remainder != 0)
        { 
            result.Append("."); 
        }
        Dictionary<long, int> map = new Dictionary<long, int>();
        while(remainder != 0)
        {
            map.Add(num, result.Length - 1);
            num = remainder * 10;
            quotient = num / den;
            remainder = num % den;
            if(map.ContainsKey(num))
            {
                result.Insert(map[num], "(");
                result.Append(")");
                break;
            }
            else
            { 
                result.Append(quotient); 
            }
            
        }
        return result.ToString();
    }
}