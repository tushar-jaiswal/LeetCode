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
