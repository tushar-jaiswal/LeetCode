//Author: Tushar Jaiswal
//Creation Date: 10/13/2018

/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Example:
Consider the following matrix:
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.*/

public class Solution {
    public bool SearchMatrix(int[,] matrix, int target) {
        int m = matrix.GetLength(0);
        int n = matrix.GetLength(1);
        if(m == 0)
        { return false; }
        int r = 0, c = n - 1;
        
        while(r < m && c >= 0)
        {
            if(matrix[r, c] == target)
            { return true; }
            if(target < matrix[r, c])
            {
                c -= 1;
            }
            else
            {
                r += 1;
            }
        }
        return false;
    }
}