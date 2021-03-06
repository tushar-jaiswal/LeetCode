//Author: Tushar Jaiswal
//Creation Date: 04/22/2017

/*Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]
sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 = row2 and col1 = col2.*/

public class NumMatrix {
    
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if(matrix.length > 0)
        {
            int numRows = matrix.length;
            int numCols = matrix[0].length;
            sum = new int[numRows][numCols];
            for(int i = 0; i < numRows; i++)
            {
                sum[i][0] = (i == 0) ? matrix[i][0] : (sum[i - 1][0] + matrix[i][0]);
                for(int j = 1; j < numCols; j++)
                {
                    if(i == 0)
                    {
                        sum[i][j] = sum[i][j - 1] + matrix[i][j];
                    }
                    else
                    {
                        sum[i][j] = matrix[i][j] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
                    }
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result;
        
        if(row1 > 0 && col1 > 0)
        {
            result = sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
        }
        else if(row1 == 0 && col1 > 0)
        {
            result = sum[row2][col2] - sum[row2][col1 - 1];
        }
        else if(col1 == 0 && row1 > 0)
        {
            result = sum[row2][col2] - sum[row1 - 1][col2];
        }
        else
        {
            result = sum[row2][col2];
        }
        
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */