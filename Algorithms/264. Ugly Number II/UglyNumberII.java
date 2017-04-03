//Author: Tushar Jaiswal
//Creation Date: 04/02/2017

/*Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note that 1 is typically treated as an ugly number, and n does not exceed 1690.*/

public class Solution {
    public int nthUglyNumber(int n) {
        int l2, l3, l5;
        int[] ugly = new int[1690];
        ugly[0] = 1;
        l2 = l3 = l5 = 0;
        for(int i = 1; i < n; i++)
        {
            ugly[i] = Math.min(ugly[l2] * 2, Math.min(ugly[l3] * 3, ugly[l5] * 5));
            if(ugly[i] == ugly[l2] * 2)
            {
                l2++;
            }
            if(ugly[i] == ugly[l3] * 3)
            {
                l3++;
            }
            if(ugly[i] == ugly[l5] * 5)
            {
                l5++;
            }
        }
        return ugly[n-1];
    }
}