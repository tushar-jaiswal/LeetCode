//Author: Tushar Jaiswal
//Creation Date: 10/14/2018

/*According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

Follow up:
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?*/

public class Solution {
    public void GameOfLife(int[,] board) {
        if(board == null || board.GetLength(0) == 0)
        { return; }
        int m = board.GetLength(0);
        int n = board.GetLength(1);
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int liveNeighbors = 0;
                for(int x = Math.Max(i - 1, 0); x < Math.Min(i + 2, m); x++)
                {
                    for(int y = Math.Max(j - 1, 0); y < Math.Min(j + 2, n); y++)
                    {
                        if(x == i && y == j)
                        { continue; }
                        if(board[x, y] == 1 || board[x, y] == 2)
                        {
                            liveNeighbors++;
                        }
                    }
                }
                
                if(board[i, j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3))
                {
                    board[i, j] = 2;
                }
                if(board[i, j] == 0 && liveNeighbors == 3)
                {
                    board[i, j] = 3;
                }
            }
        }
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                board[i, j] %= 2;
            }
        }
    }
}