//Author: Tushar Jaiswal
//Creation Date: 06/05/2016

/*Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.*/

public class Solution {
    public int romanToInt(String s) {
        int result=0, first, second, i;
        
        for(i = 0; i < s.length(); i++)
        {
            first = romanCharToInt(s.charAt(i));
            if(i+1 < s.length())
            {
                second = romanCharToInt(s.charAt(i+1));
                
                if(first < second)
                {
                    result += second - first;
                    i++;
                    continue;
                }
            }
            
            result += first;
        }
        return result;
    }
    
    private int romanCharToInt(char c)
    {
        if(c == 'I') { return 1; }
        if(c == 'V') { return 5; }
        if(c == 'X') { return 10; }
        if(c == 'L') { return 50; }
        if(c == 'C') { return 100; }
        if(c == 'D') { return 500; }
        if(c == 'M') { return 1000; }
        else return 0;
    }
}