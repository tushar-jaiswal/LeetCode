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

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
        {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        result.append((numerator < 0) ^ (denominator < 0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long quotient = num / den;
        long remainder = num % den;
        result.append(quotient);
        if(remainder != 0)
        { 
            result.append("."); 
        }
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        while(remainder != 0)
        {
            map.put(num, result.length() - 1);
            num = remainder * 10;
            quotient = num / den;
            remainder = num % den;
            if(map.containsKey(num))
            {
                result.insert(map.get(num), "(");
                result.append(")");
                break;
            }
            else
            { 
                result.append(quotient); 
            }
            
        }
        return result.toString();
    }
}