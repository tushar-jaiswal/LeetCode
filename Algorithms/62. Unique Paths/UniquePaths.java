//Author: Tushar Jaiswal
//Creation Date: 09/15/2018

/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?
Note: m and n will be at most 100.

Example 1:
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:
Input: m = 7, n = 3
Output: 28*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathsFrom = new int[m + 1][n + 1];
        return 1 + dfs(1, 1, m, n, pathsFrom);
    }
    
    public int dfs(int x, int y, int m , int n, int[][] pathsFrom)
    {
        if(x == m && y == n)
        { return 0; }
        int result = 0;
        if(x + 1 <= m && y + 1 <= n) 
        { result += 1; }
        if(x + 1 <= m)
        {
            if(pathsFrom[x + 1][y] == 0)
            { pathsFrom[x + 1][y] = dfs(x + 1, y, m, n, pathsFrom); }
            result += pathsFrom[x + 1][y]; 
        }
        if(y + 1 <= n) 
        { 
            if(pathsFrom[x][y + 1] == 0)
            { pathsFrom[x][y + 1] = dfs(x, y + 1, m, n, pathsFrom); }
            result += pathsFrom[x][y + 1]; 
        }
        return result; 
    }
}