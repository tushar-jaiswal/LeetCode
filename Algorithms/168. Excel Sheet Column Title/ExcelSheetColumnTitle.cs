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
        int rem;
        
        do
        {
            n = n - 1;
            rem = n % 26;
            result = GetChar(rem) + result;
            n = n / 26;
        }while(n != 0);
        
        return result;
    }
    
    private char GetChar(int i)
    {
        switch(i) 
        {
            case 0: return 'A';
            case 1: return 'B';
            case 2: return 'C';
            case 3: return 'D';
            case 4: return 'E';
            case 5: return 'F';
            case 6: return 'G';
            case 7: return 'H';
            case 8: return 'I';
            case 9: return 'J';
            case 10: return 'K';
            case 11: return 'L';
            case 12: return 'M';
            case 13: return 'N';
            case 14: return 'O';
            case 15: return 'P';
            case 16: return 'Q';
            case 17: return 'R';
            case 18: return 'S';
            case 19: return 'T';
            case 20: return 'U';
            case 21: return 'V';
            case 22: return 'W';
            case 23: return 'X';
            case 24: return 'Y';
            case 25: return 'Z';
            default: return ' ';
        }
    }
}