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

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        //PriorityQueue is storing for each prime int[3] { nextUglyNum, lastUglyIndexUsed, primeNum}
        
        for(int i = 0; i < primes.length; i++)
        { pQueue.offer(new int[]{primes[i], 0, primes[i]}); }
        
        for(int i = 1; i < n; i++)
        {
            ugly[i] = pQueue.peek()[0];
            while(pQueue.peek()[0] == ugly[i])
            {
                int[] element = pQueue.poll();
                pQueue.offer(new int[]{element[2] * ugly[element[1]], element[1] + 1, element[2]});
            }
        }
        return ugly[n - 1];
    }
}