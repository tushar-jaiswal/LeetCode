//Author: Tushar Jaiswal
//Creation Date: 07/07/2019

/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/

/*Runtime Complexity: O(mn)
Space Complexity: O(mn)*/

public class Solution {
    public int MinPathSum(int[][] grid) {
        int m = grid.GetLength(0);
        int n = grid[0].Length;
        if(m == 0 || n == 0)
        { return -1; }
        int[,] sum = new int[m, n];
        for (int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                 sum[i, j] = -1;
            }
        }
        return Dfs(grid, 0, 0, sum);
    }

    public int Dfs(int[][] grid, int row, int col, int[, ] sum)
    {
        int m = grid.GetLength(0);
        int n = grid[0].Length;
        if(row < m && col < n)
        {
            if(sum[row, col] != -1)
            { return sum[row, col]; }

            if(row == m - 1 && col == n - 1)
            { sum[row, col] = grid[row][col]; }
            else
            { sum[row, col] = grid[row][col] + Math.Min(Dfs(grid, row + 1, col, sum), Dfs(grid, row, col + 1, sum)); }
            return sum[row, col];
        }
        else
        { return Int32.MaxValue; }
    }
}
