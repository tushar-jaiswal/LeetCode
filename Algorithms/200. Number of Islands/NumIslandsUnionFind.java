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

class Solution {
    int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {  
        int m = grid.length;  
        if(m == 0)
        { return 0; }
        int n = grid[0].length;  
        UnionFind uf = new UnionFind(grid);  
        for (int i = 0; i < m; i++) 
        {  
            for (int j = 0; j < n; j++) 
            {  
                if (grid[i][j] == '1') 
                {  
                    for (int[] move : moves) 
                    {
                        int x = i + move[0];
                        int y = j + move[1];
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') 
                        {  
                            int node1 = i * n + j;
                            int node2 = x * n + y;
                            uf.union(node1, node2);  
                        }  
                    }  
                }  
            }  
        }  
        return uf.components;
    }
}
class UnionFind 
{
    int[] parent;  
    int m, n;
    int components = 0;

    public UnionFind(char[][] grid) 
    {  
        m = grid.length;  
        n = grid[0].length;  
        parent = new int[m * n];  
        for (int i = 0; i < m; i++) 
        {  
            for (int j = 0; j < n; j++) 
            {  
                if (grid[i][j] == '1') 
                {
                    int pos = i * n + j;
                    parent[pos] = pos;
                    components++;
                }
            }  
        }  
    }
    public void union(int node1, int node2) 
    {  
        int parent1 = find(node1);
        int parent2 = find(node2);
        if(parent1 != parent2) 
        {
            parent[parent1] = parent2;
            components--;
        }
    }
    public int find (int node) 
    {  
        if(parent[node] == node) 
        { return node; }
        parent[node] = find(parent[node]);  
        return parent[node];
    }
}