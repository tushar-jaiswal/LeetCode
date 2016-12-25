//Author: Tushar Jaiswal
//Creation Date: 12/25/2016

/*Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1*/

public class Solution {
    static HashMap<Integer, Integer> HappyNumbers = new HashMap<Integer, Integer>();
    static HashMap<Integer, Integer> UnhappyNumbers = new HashMap<Integer, Integer>();
    
    public boolean isHappy(int n) {
        List<Integer> oldNumbers = new ArrayList<Integer>();
        
        do
        {
            if(HappyNumbers.containsKey(n)) { return true; }
            if(UnhappyNumbers.containsKey(n)) { return false; }
            
            oldNumbers.add(n);
            n = getSumOfSquaredDigits(n);
            if(n == 1)
            { 
                for(int d : oldNumbers)
                {
                    HappyNumbers.put(d, 1);
                }
                return true; 
            }
            else
            {
                for(int d : oldNumbers)
                {
                    if(d == n)
                    {
                        for(int num : oldNumbers)
                        {
                            UnhappyNumbers.put(num, 1);
                        }
                        return false;
                    }
                }
            }
        }while(n != 1);
        return true;
    }
    
    private int getSumOfSquaredDigits(int n)
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