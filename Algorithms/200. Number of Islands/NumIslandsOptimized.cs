//Author: Tushar Jaiswal
//Creation Date: 09/16/2018

/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3*/

public class Solution {
    public int NumIslands(char[,] grid) {
        int noOfIslands = 0;
        for(int i = 0; i < grid.GetLength(0); i++)
        {
            for(int j = 0; j < grid.GetLength(1); j++)
            {
                if(grid[i, j] == '1')
                {
                    Visit(grid, i, j);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    
    public void Visit(char[,] grid, int x, int y)
    {
        if(x >= 0 && y >= 0 && x < grid.GetLength(0) && y < grid.GetLength(1) && grid[x, y] == '1')
        {
            grid[x, y] = 'x';
            Visit(grid, x - 1, y);
            Visit(grid, x + 1, y);
            Visit(grid, x, y - 1);
            Visit(grid, x, y + 1);
        }
    }
}