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

class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
        { return false; }
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == word.charAt(0) && dfs(board, word, 0, i, j))
                { return true; }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int pos, int i, int j)
    {
        if(pos + 1 == word.length())
        { return true; }
        int[][] move = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        char temp = board[i][j];
        board[i][j] = '0';
        for(int index = 0; index < move.length; index++)
        {
            int x = i + move[index][0];
            int y = j + move[index][1];
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length)
            {
                if(board[x][y] == word.charAt(pos + 1) && dfs(board, word, pos + 1, x, y))
                { return true; }
            }
        }
        board[i][j] = temp;
        return false;
    }
}