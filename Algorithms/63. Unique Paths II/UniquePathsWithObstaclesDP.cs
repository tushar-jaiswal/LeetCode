//Author: Tushar Jaiswal
//Creation Date: 09/15/2018

/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.
Note: m and n will be at most 100.

Example 1:
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right*/

public class Solution {
    public int UniquePathsWithObstacles(int[,] obstacleGrid) {
        int m = obstacleGrid.GetLength(0);
        int n = obstacleGrid.GetLength(1);
        int[] col = new int[m];
        for(int i = 0; i < m; i++)
        {
            if(obstacleGrid[i, 0] == 0)
            { col[i] = 1; }
            else
            { break; }
        }
        for(int j = 1; j < n; j++)
        {
            for(int i = 0; i < m; i++)
            {
                if(obstacleGrid[i, j] == 0 && i != 0)
                { col[i] += col[i - 1]; }
                else if(obstacleGrid[i, j] == 1)
                { col[i] = 0; }
            }
        }
        return col[m - 1];
    }
}