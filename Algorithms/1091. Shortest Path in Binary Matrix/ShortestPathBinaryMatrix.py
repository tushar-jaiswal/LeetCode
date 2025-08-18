# Author: Tushar Jaiswal
# Creation Date: 2025-08-17

# Problem Source: https://leetcode.com/problems/shortest-path-in-binary-matrix

# Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

# A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

# All the visited cells of the path are 0.
# All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
# The length of a clear path is the number of visited cells of this path.

# Example 1:
# Input: grid = [[0,1],[1,0]]
# Output: 2

# Example 2:
# Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
# Output: 4

# Example 3:
# Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
# Output: -1
 
# Constraints:
# n == grid.length
# n == grid[i].length
# 1 <= n <= 100
# grid[i][j] is 0 or 1

# Runtime complexity: O(n) where n is the number of cells in the grid.
# Space complexity: O(n)

from collections import deque

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        n = len(grid)
        directions = [(0, -1), (0, 1), (1, -1), (1, 0), (1, 1), (-1, -1), (-1, 0), (-1, 1)]

        if (grid[0][0] != 0 or grid[n - 1][n - 1]):
            return -1
        
        queue = deque([(0, 0)]) # same as queue.append((0, 0))
        visited = {(0, 0)} # same as visited = set() and visited.add((0,0))
        distance = 0

        while queue:
            level_size = len(queue)
            distance += 1
            for i in range(level_size):
                row, col = queue.popleft()
                if row == n - 1 and col == n - 1:
                    return distance
                for dx, dy in directions:
                    r, c = row + dx, col + dy
                    if 0 <= r < n and 0 <= c < n and grid[r][c] == 0 and (r, c) not in visited:
                        visited.add((r, c))
                        queue.append((r, c))
        
        return -1

        # Following logic leads to Time Limit Exceeded on a 146 length BFS answer
        # visited = set()
        # distance = 0

        # while queue:
        #     level_size = len(queue)
        #     distance += 1
        #     for i in range(level_size):
        #         row, col = queue.popleft()
        #         visited.add((row, col))
        #         if row == n - 1 and col == n - 1:
        #             return distance
        #         for dx, dy in directions:
        #             r, c = row + dx, col + dy
        #             if 0 <= r < n and 0 <= c < n and grid[r][c] == 0 and (r, c) not in visited:
        # Same cell gets added to queue multiple times here when visisting neighbors of
        # cells close (next to or 1 cell in between them) to each other. 
        # This happens as we didn't add neighbor to visited set the first time it was
        # added to queue. Long queue causes BFS level loop to run longer.
        # Hence add to visited set here.
        #                 queue.append((r, c))
