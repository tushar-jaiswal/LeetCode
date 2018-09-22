//Author: Tushar Jaiswal
//Creation Date: 09/19/2018

/*Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.*/

public class Solution {
    public bool Exist(char[,] board, string word) {
        if(word.Length == 0)
        { return false; }
        for(int i = 0; i < board.GetLength(0); i++)
        {
            for(int j = 0; j < board.GetLength(1); j++)
            {
                if(board[i, j] == word[0] && DFS(board, word, 0, i, j))
                { return true; }
            }
        }
        return false;
    }
    
    public bool DFS(char[,] board, string word, int pos, int i, int j)
    {
        if(pos + 1 == word.Length)
        { return true; }
        int[,] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        char temp = board[i, j];
        board[i, j] = '0';
        for(int index = 0; index < move.GetLength(0); index++)
        {
            int x = i + move[index, 0];
            int y = j + move[index, 1];
            if(x >= 0 && y >= 0 && x < board.GetLength(0) && y < board.GetLength(1))
            {
                if(board[x, y] == word[pos + 1] && DFS(board, word, pos + 1, x, y))
                { return true; }
            }
        }
        board[i, j] = temp;
        return false;
    }
}