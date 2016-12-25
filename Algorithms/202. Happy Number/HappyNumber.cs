//Author: Tushar Jaiswal
//Creation Date: 12/17/2016

/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1*/

public class Solution {
    static Dictionary<int, int> HappyNumbers = new Dictionary<int, int>();
    static Dictionary<int, int> UnhappyNumbers = new Dictionary<int, int>();
    
    public bool IsHappy(int n) {
        List<int> oldNumbers = new List<int>();
        
        do
        {
            if(HappyNumbers.ContainsKey(n)) { return true; }
            if(UnhappyNumbers.ContainsKey(n)) { return false; }
            
            oldNumbers.Add(n);
            n = GetSumOfSquaredDigits(n);
            if(n == 1)
            { 
                foreach(int d in oldNumbers)
                {
                    HappyNumbers.Add(d, 1);
                }
                return true; 
            }
            else
            {
                foreach(int d in oldNumbers)
                {
                    if(d == n)
                    {
                        foreach(int num in oldNumbers)
                        {
                            UnhappyNumbers.Add(num, 1);
                        }
                        return false;
                    }
                }
            }
        }while(n != 1);
        return true;
    }
    
    ///<summary>This function returns the sum of the squares of the digits of the input argument</summary>
    private int GetSumOfSquaredDigits(int n)
    {
        int sum = 0;
        while(n != 0)
        {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}