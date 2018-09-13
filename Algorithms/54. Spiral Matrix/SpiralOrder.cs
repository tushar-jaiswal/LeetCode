//Author: Tushar Jaiswal
//Creation Date: 09/12/2018

/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/

public class Solution {
    public IList<int> SpiralOrder(int[,] matrix) {
        List<int> result = new List<int>();
        int m = matrix.GetLength(0);
        int n = matrix.GetLength(1);
        if(m == 0)
        { return result; }
        int[] rowChange = {0, 1, 0, -1};
        int[] colChange = {1, 0, -1, 0};
        int changeIndex = 0;
        int r = 0, c = 0, nextR, nextC;
        bool[,] seen = new bool[m, n];
        for(int i = 0; i < m * n; i++)
        {
            result.Add(matrix[r, c]);
            seen[r, c] = true;
            nextR = r + rowChange[changeIndex];
            nextC = c + colChange[changeIndex];
            if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !seen[nextR, nextC])
            {
                r = nextR;
                c = nextC;
            }
            else
            {
                changeIndex = (changeIndex + 1) % 4;
                r += rowChange[changeIndex];
                c += colChange[changeIndex];
            }
        }
        return result;
    }
}