//Author: Tushar Jaiswal
//Creation Date: 02/21/2017

/*Count the number of prime numbers less than a non-negative number, n.*/

public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        
        for(int i = 2; i < n; i++)
        { isPrime[i] = true; }
        
        for(int i = 2; i * i < n; i++)
        {
            if(isPrime[i])
            {
                for(int j = i * i; j < n; j += i)
                { isPrime[j] = false; }
            }
        }
        
        for(int i = 2; i < n; i++)
        { 
            if(isPrime[i])
            { count++; }
        }
        return count;
    }
}