//Author: Tushar Jaiswal
//Creation Date: 11/23/2020

/*Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.

Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.

Note: The length of each dimension in the given grid does not exceed 50.*/

/*Runtime Complexity: O(size of grid)
Space Complexity: O(1)*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        var onePositions = new ArrayList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    onePositions.add(new int[]{i, j});
                }
            }
        }

        for (int[] position : onePositions) {
            int x = position[0];
            int y = position[1];
            if (grid[x][y] == 1) {
                maxArea = Math.max(maxArea, bfs(grid, x, y));
            }
        }

        return maxArea;
    }

    private int bfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        int area = 0;
        if (grid[x][y] == 1) {
            area = 1;
            grid[x][y] = -1;
            area += bfs(grid, x + 1, y);
            area += bfs(grid, x, y + 1);
            area += bfs(grid, x - 1, y);
            area += bfs(grid, x, y - 1);

        }

        return area;
    }
}
