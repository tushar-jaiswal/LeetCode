//Author: Tushar Jaiswal
//Creation Date: 09/16/2018

/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
Example 1:
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

Example 2:
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/

public class Solution {
    public void SetZeroes(int[,] matrix) {
        int col0 = 1;
        int m = matrix.GetLength(0);
        int n = matrix.GetLength(1);
        for(int i = 0; i < m; i++)
        {
            if(matrix[i, 0] == 0)
            { col0 = 0; }
            for(int j = 1; j < n; j++)
            {
                if(matrix[i, j] == 0)
                {
                    matrix[i, 0] = 0;
                    matrix[0, j] = 0;
                }
            }
        }
        for(int j = 1; j < n; j++)
        {
            if(matrix[0, j] == 0)
            {
                for(int i = 0; i < m; i++)
                {
                    matrix[i, j] = 0;
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            if(matrix[i, 0] == 0)
            {
                for(int j = 0; j < n; j++)
                {
                    matrix[i, j] = 0;
                }
            }
            if(col0 == 0)
            {
                matrix[i, 0] = 0;
            }
        }
    }
}