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

class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<Integer>();
        int[] countSquare = new int[n];
        for(int i = 1; i * i <= n; i++)
        {
            perfectSquares.add(i * i);
            countSquare[i * i - 1] = 1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i : perfectSquares)
        {
            queue.offer(i);
        }
        if(perfectSquares.get(perfectSquares.size() - 1) == n)
        {
            return 1;
        }
        
        int count = 1;
        while(!queue.isEmpty())
        {
            count++;
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int num = queue.poll();
                for(int square : perfectSquares)
                {
                    if(num + square == n)
                    {
                        return count;
                    }
                    if(num + square < n && countSquare[num + square - 1] == 0)
                    {
                        queue.offer(num + square);
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