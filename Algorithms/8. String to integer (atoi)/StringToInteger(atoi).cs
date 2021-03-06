//Author: Tushar Jaiswal
//Creation Date: 06/05/2016

/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.*/

public class Solution {
    public int MyAtoi(string str) {
        int i, result=0, sign = 1;
        
        str = str.Trim();
        if(str.Length == 0) { return 0; }
        
        if(str[0] == '+' || str[0] == '-')
        {
            if(str[0] == '-')
            { sign = -1; }
            str = str.Substring(1);
        }
        
        try
        {
            for(i = 0; i < str.Length; i++)
            {
                int digit;
                if(TryParseCharToInt(str[i], out digit))
                { result = checked(result * 10 + digit); }
                else
                { break; }
            }
        }
        catch (OverflowException)
        {
            if(sign == 1)
            { return Int32.MaxValue; }
            else
            { return Int32.MinValue; }
        }
        return sign * result;
    }
    
    private bool TryParseCharToInt(char c, out int i)
    {
        i = -1;
        if(c == '0') {i = 0;}
        else if(c == '1') { i = 1; }
        else if(c == '2') { i = 2; }
        else if(c == '3') { i = 3; }
        else if(c == '4') { i = 4; }
        else if(c == '5') { i = 5; }
        else if(c == '6') { i = 6; }
        else if(c == '7') { i = 7; }
        else if(c == '8') { i = 8; }
        else if(c == '9') { i = 9; }
        else {return false;}
        return true;
    }
}