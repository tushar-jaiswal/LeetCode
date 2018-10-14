//Author: Tushar Jaiswal
//Creation Date: 10/14/2018

/*Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:
Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.

Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.*/

public class Solution {
    private List<int> countSquares = new List<int>(new int[]{0});
        
    public int NumSquares(int n) {
        while(countSquares.Count < n + 1)
        {
            int num = countSquares.Count;
            int minCount = Int32.MaxValue;
            for(int i = 1; i * i <= num; i++)
            {
                minCount = Math.Min(minCount, countSquares[num - i * i] + 1);
                //Incrementing the count of a previous num by 1 as we get this number by adding a perfect square (i * i) to a previous number (num - i * i)
            }
            countSquares.Add(minCount);
        }
        return countSquares[n];
    }
}