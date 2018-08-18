//Author: Tushar Jaiswal
//Creation Date: 08/18/2018

/*Write a program to find the nth super ugly number.
Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

Example:
Input: n = 12, primes = [2,7,13,19]
Output: 32 
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes = [2,7,13,19] of size 4.

Note:
1 is a super ugly number for any given primes.
The given numbers in primes are in ascending order.
0 < k = 100, 0 < n = 106, 0 < primes[i] < 1000.
The nth super ugly number is guaranteed to fit in a 32-bit signed integer.*/

public class Solution {
    public int NthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        SortedList<int, Tuple<int, int>> list = new SortedList<int, Tuple<int, int>>(new DuplicateKeyComparer<int>());
        //SortedList is storing for each prime <nextUglyNum, <lastUglyIndexUsed, primeNum>>
        
        for(int i = 0; i < primes.Length; i++)
        { list.Add(primes[i], new Tuple<int, int>(0, primes[i])); }
        
        for(int i = 1; i < n; i++)
        {
            ugly[i] = list.Keys[0];
            while(list.Keys[0] == ugly[i])
            {
                int lastUglyIndexUsed = list.Values[0].Item1;
                int prime = list.Values[0].Item2;
                list.RemoveAt(0);
                list.Add(prime * ugly[lastUglyIndexUsed], new Tuple<int, int>(lastUglyIndexUsed + 1, prime));
            }
        }
        return ugly[n - 1];
    }
}

public class DuplicateKeyComparer<TKey> : IComparer<TKey> where TKey : IComparable
{
    public int Compare(TKey a, TKey b)
    {
        int result = a.CompareTo(b);
        return result == 0 ? 1 : result;
    }
}