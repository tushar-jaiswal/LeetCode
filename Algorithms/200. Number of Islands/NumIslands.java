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

import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        HashSet<Map.Entry<Integer, Integer>> ones = new HashSet<Map.Entry<Integer, Integer>>();
        HashSet<Map.Entry<Integer, Integer>> visited = new HashSet<Map.Entry<Integer, Integer>>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    ones.add(new AbstractMap.SimpleEntry<Integer, Integer>(i, j));
                }
            }
        }
        int noOfIslands = 0;
        for(Map.Entry<Integer, Integer> kvp : ones)
        {
            if(!visited.contains(kvp))
            {
                visit(grid, kvp, visited);
                noOfIslands++;
            }
        }
        return noOfIslands;
    }
    
    public void visit(char[][] grid, Map.Entry<Integer, Integer> kvp, HashSet<Map.Entry<Integer, Integer>> visited)
    {
        visited.add(kvp);
        int x = kvp.getKey();
        int y = kvp.getValue();
        
        if(x - 1 >= 0 && grid[x - 1][y] == '1')
        {
            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(x - 1, y);
            if(!visited.contains(entry))
            { visit(grid, entry, visited); }
        }
        if(x + 1 < grid.length && grid[x + 1][y] == '1')
        {
            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(x + 1, y);
            if(!visited.contains(entry))
            { visit(grid, entry, visited); }
        }
        if(y - 1 >= 0 && grid[x][y - 1] == '1')
        {
            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(x, y - 1);
            if(!visited.contains(entry))
            { visit(grid, entry, visited); }
        }
        if(y + 1 < grid[0].length && grid[x][y + 1] == '1')
        {
            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleEntry<Integer, Integer>(x, y + 1);
            if(!visited.contains(entry))
            { visit(grid, entry, visited); }
        }
    }
}