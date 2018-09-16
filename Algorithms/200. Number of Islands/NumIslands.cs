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
        HashSet<Tuple<int, int>> ones = new HashSet<Tuple<int, int>>();
        HashSet<Tuple<int, int>> visited = new HashSet<Tuple<int, int>>();
        for(int i = 0; i < grid.GetLength(0); i++)
        {
            for(int j = 0; j < grid.GetLength(1); j++)
            {
                if(grid[i, j] == '1')
                {
                    ones.Add(new Tuple<int, int>(i, j));
                }
            }
        }
        int noOfIslands = 0;
        foreach(Tuple<int, int> tpl in ones)
        {
            if(!visited.Contains(tpl))
            {
                Visit(grid, tpl, visited);
                noOfIslands++;
            }
        }
        return noOfIslands;
    }
    
    public void Visit(char[,] grid, Tuple<int, int> tpl, HashSet<Tuple<int, int>> visited)
    {
        visited.Add(tpl);
        int x = tpl.Item1;
        int y = tpl.Item2;
        
        if(x - 1 >= 0 && grid[x - 1, y] == '1')
        {
            Tuple<int, int> point = new Tuple<int, int>(x - 1, y);
            if(!visited.Contains(point))
            { Visit(grid, point, visited); }
        }
        if(x + 1 < grid.GetLength(0) && grid[x + 1, y] == '1')
        {
            Tuple<int, int> point = new Tuple<int, int>(x + 1, y);
            if(!visited.Contains(point))
            { Visit(grid, point, visited); }
        }
        if(y - 1 >= 0 && grid[x, y - 1] == '1')
        {
            Tuple<int, int> point = new Tuple<int, int>(x, y - 1);
            if(!visited.Contains(point))
            { Visit(grid, point, visited); }
        }
        if(y + 1 < grid.GetLength(1) && grid[x, y + 1] == '1')
        {
            Tuple<int, int> point = new Tuple<int, int>(x, y + 1);
            if(!visited.Contains(point))
            { Visit(grid, point, visited); }
        }
    }
}