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

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 || n == 0)
        { return -1; }
        int[][] sum = new int[grid.length][grid[0].length];
        for (int[] row: sum)
        { Arrays.fill(row, -1); }
        return dfs(grid, 0, 0, sum);
    }

    public int dfs(int[][] grid, int row, int col, int[][] sum)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(row < m && col < n)
        {
            if(sum[row][col] != -1)
            { return sum[row][col]; }

            if(row == m - 1 && col == n - 1)
            { sum[row][col] = grid[row][col]; }
            else
            { sum[row][col] = grid[row][col] + Math.min(dfs(grid, row + 1, col, sum), dfs(grid, row, col + 1, sum)); }
            return sum[row][col];
        }
        else
        { return Integer.MAX_VALUE; }
    }
}
