//Author: Tushar Jaiswal
//Creation Date: 06/24/2016
/*Determine if a Sudoku is valid.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int i, j, k;
        
        for(i = 0; i < board.length; i++)
        {
            HashMap row = new HashMap();
            HashMap col = new HashMap();
            for(j = 0; j < board[0].length; j++)
            {
                if(board[i][j] != '.')
                {
                    if(row.get(board[i][j]) != null)
                    { return false; }
                    else
                    { row.put(board[i][j], 0); }
                }
                if(board[j][i] != '.')
                {
                    if(col.get(board[j][i]) != null)
                    { return false; }
                    else
                    { col.put(board[j][i], 0); }
                }
            }
        }
        
        for(k=0; k < 9; k+=3)
        {
            HashMap box = new HashMap();
            for(i = k; i < k+3; i++)
            {
                for(j = 0; j < 3; j++)
                {
                    if(board[i][j] != '.')
                    {
                        if(box.get(board[i][j]) != null)
                        { return false; }
                        else
                        { box.put(board[i][j], 0); }
                    }
                }
            }
            box.clear();
            for(i = k; i < k+3; i++)
            {
                for(j = 3; j < 6; j++)
                {
                    if(board[i][j] != '.')
                    {
                        if(box.get(board[i][j]) != null)
                        { return false; }
                        else
                        { box.put(board[i][j], 0); }
                    }
                }
            }
            box.clear();
            for(i = k; i < k+3; i++)
            {
                for(j = 6; j < 9; j++)
                {
                    if(board[i][j] != '.')
                    {
                        if(box.get(board[i][j]) != null)
                        { return false; }
                        else
                        { box.put(board[i][j], 0); }
                    }
                }
            }
        }
        return true;
    }
}