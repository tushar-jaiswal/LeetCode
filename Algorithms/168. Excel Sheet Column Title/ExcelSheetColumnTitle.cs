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
    public string ConvertToTitle(int n) {
        string result = "";
        
        if(n <= 0)
        {
            throw new ArgumentOutOfRangeException("n", "Input must be greater than 0.");
        }
        
        do
        {
            n = n - 1;
            result = (char) (n % 26 + 'A') + result;
            n = n / 26;
        }while(n != 0);
        
        return result;
    }
}