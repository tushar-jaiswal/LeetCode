//Author: Tushar Jaiswal
//Creation Date: 08/01/2016

/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB */
    
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        
        if(n <= 0)
        {
            throw new IllegalArgumentException("Invalid input.");
        }
        
        while(n != 0)
        {
            n -= 1;
            result.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        
        result.reverse();
        return result.toString();
    }
}