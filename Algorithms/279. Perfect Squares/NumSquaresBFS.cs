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
    public int NumSquares(int n) {
        List<int> perfectSquares = new List<int>();
        int[] countSquare = new int[n];
        for(int i = 1; i * i <= n; i++)
        {
            perfectSquares.Add(i * i);
            countSquare[i * i - 1] = 1;
        }
        Queue<int> queue = new Queue<int>();
        foreach(int i in perfectSquares)
        {
            queue.Enqueue(i);
        }
        if(perfectSquares[perfectSquares.Count - 1] == n)
        {
            return 1;
        }
        
        int count = 1;
        while(queue.Count != 0)
        {
            count++;
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                int num = queue.Dequeue();
                foreach(int square in perfectSquares)
                {
                    if(num + square == n)
                    {
                        return count;
                    }
                    if(num + square < n && countSquare[num + square - 1] == 0)
                    {
                        queue.Enqueue(num + square);
                        countSquare[num + square - 1] = count;
                    }
                    else if(num + square > n)
                    {
                        break;
                    }
                }
            }
        }
        return 0;
    }
}